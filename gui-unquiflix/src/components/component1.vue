<template>
    <div class="container-fluid" id="component1">
        <nav id="barra-principal" class="navbar navbar-dark bg-dark fixed-top ">
            <h2 class="text-white" id="unqHead-Title">UNQUIFLIX</h2>

            <input class="input-text" v-model="peli_find" placeholder="Buscar..">
            <div class="div-select">
                <select class="custom-select" v-model="peliculasearch" name="" id="">
                    <option value="" disabled selected hidden>Elegir categoría</option>
                    <option v-for="cate in categorias" :key="cate">
                        {{cate}}
                    </option>
                    <option value="">TODAS</option>
                </select>
            </div>
            <h3 class="text-warning" v-if="loggedUser.esAdmin">ADMIN</h3>
            <h3 style="color:red!important;">{{loggedUser.nombre}}</h3>
            <button class="btn btn-danger" v-on:click="logOut()">Log out</button>
        </nav>

        <div class="float-right mr-4">
            <router-link class="btn btn-success m-0 pl-2 pr-2 pt-0 pb-0" :to="{ name: 'pelicula', params: {loggedUser: loggedUser}}" v-if="loggedUser.esAdmin">+</router-link>
        </div>

        <div v-if="!peli_find && !peliculasearch">
            <h3 class="text-white d-inline-block mr-3">Estrenos de los últimos: </h3>
            <div class="div-select d-inline-block">
                <select class="custom-select" v-model="estreno" name="" id="">
                    <option v-for="d in [
                        {value: 3, desc: '3 días'},
                        {value: 7, desc: 'Semana'},
                        {value: 30, desc: 'Mes'}
                    ]" :value="d.value" :key="d.value">
                        {{d.desc}}
                    </option>
                </select>
            </div>
            <div class="card-container">
                <div v-for="pelicula in peliculasPorEstreno()" :key="pelicula.id">
                    <tarjeta :user="loggedUser" :peli="pelicula" :on-toggle="leerPeliculas"> </tarjeta>
                </div>
            </div>
        </div>

        <div v-for="cat in categoriaFiltered" :key="cat" >
                <h3 class="categoriaHead" >{{cat}} </h3>
            <div class="card-container">
                <div v-for="pelicula in peliculasPorCategoria(cat)" :key="pelicula.id">
                    <tarjeta :user="loggedUser" :peli="pelicula" :on-toggle="leerPeliculas"> </tarjeta>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import API from "../service/api";
    import {subDays} from "date-fns";
    import moment from "moment";
    import Tarjeta from './Tarjeta.vue'

    export default {
        computed: {
            peliculaFilter: function() {
                var peli = this.peliculasearch;
                return this.peliculas.filter(
                    e => e.categoria.toLowerCase().indexOf(peli.toLowerCase()) !== -1
            );
            },

            peliculaFilterName: function() {
                var peliname = this.peli_find;
                return this.peliculaFilter.filter(
                    e => e.titulo.toLowerCase().indexOf(peliname.toLowerCase()) !== -1
            );
            },

            categoriaFiltered: function () {
                return this.peliculaFilterName
                    .map(peli => peli.categoria)
            .filter(function (elem, pos, arr) {
                    return arr.indexOf(elem) == pos;
                });
            },

            userResponsive: function(){
              if (this.loggedUser.esAdmin) {
                  return this.peliculaFilterName;
              }else{
                  return this.activadasFiltered;
              }
            },

            activadasFiltered: function () {
                return this.peliculaFilterName
                    .filter(p => p.activa==true);
            }
        },

        name: "component1",
        components: {
            'tarjeta': Tarjeta
        },

        data() {
            return {
                peliculaSelected: "",
                peliculasearch: "",
                peliculas: [],
                categorias: [],
                peli_find: "",
                loggedUser: {},
                estreno: 3
            };

        },

        created() {
            this.leerPeliculas();
            this.loggedUser = this.$session.get("unqf");
            API.get("/categories")
                .then(c => this.categorias = c)
                .catch(e => alert(e));
        },
       beforeCreate: function () {
            if (!this.$session.exists()) {
                this.$router.push('/')
            }

        },

        methods: {
            leerPeliculas() {
                var self =this;
                API.get("")
                    .then(response => self.callBack(response))
                    .catch(e => alert(e));
            },
            
            logOut:function(){
                this.$session.destroy();
                this.$router.push('/');
            },


            
            callBack(r){
                this.peliculas = r;
            },
            
            peliculasPorCategoria(categoria) {
                return this.userResponsive
                    .filter(p => p.categoria == categoria);
            },

            peliculasPorEstreno() {
                return this.peliculas.filter(p =>
                    moment(p.estreno, "YYYY-MM-DD") >= subDays(new Date(), this.estreno)
                );
            }
        }
    };
</script>

<style scoped>
    #component1 {
        margin-top: 100px;
    }

    ul li {
        color: white;
    }

    .card-container {
        clear: left;
        margin-left:1.5em;

    }

    .div-search {
        width: 500px !important;
    }

    .categoriaHead {
        position: relative;
        float: left;
        clear: both;
        color: #337ab7;
        font-weight: bold;
        height: 10px;
        line-height: 10px;
        margin-left:1em;
        padding-top: 50px;
        padding-bottom: 10px;
    }

    /*EStilo nav*/
    #barra-principal{
        height:10vh!Important;
    }
    .text-white{
        font-size: 2vw!important;
    }
    h3{
        font-size: 2vw!important;
    }

    .div-select{
        width:18vw;
    }
    .custom-select{
        width: 17vw;
        height:50%;
        font-size: 75%;
    }
    .input-text{
        width:20vw;
        height: 50%!important;
        font-size: 75%;
        padding: 1em;
    }
    .btn-danger{
        height:80%!important;
        width:10%!important;
        font-size: 80%!important;
        padding:0.5vw!important;
    }
    .btn-success{
        height:8vh!important;
        width:8vh!important;
        padding:0 0.5vw 0 0.5vw!important;
        font-size:3vw;
    }


</style>