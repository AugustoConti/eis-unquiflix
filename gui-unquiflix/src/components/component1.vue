<template>
    <div class="container-fluid" id="component1">
        <nav id="barra-principal" class="navbar navbar-dark bg-dark fixed-top ">
            <p id="unqHead-Title" style="color:white;">UNQUIFLIX</p>
            <p style="color:red!important;">{{loggedUser.nombre}}</p>
            <input type="search" v-model="peli_find" placeholder="Buscar..">
            <div class="div-select">
                <select class="custom-select" v-model="peliculasearch" name="" id="">
                    <option value="" disabled selected hidden>Elegir categoría</option>
                    <option v-for="cate in categorias" :key="cate">
                        {{cate}}
                    </option>
                    <option value="">TODAS</option>
                </select>
            </div>
        </nav>
        <div class="float-right mr-4">
          <router-link class="btn btn-success m-0 pl-2 pr-2 pt-0 pb-0" :to="{ name: 'pelicula'}" v-if="loggedUser.esAdmin"><h1>+</h1></router-link>
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
                    <tarjeta :peli="pelicula" :on-toggle="leerPeliculas"> </tarjeta>
                </div>
            </div>
        </div>
        <div v-for="cat in categoriaFiltered" :key="cat" >
            <h3 class="categoriaHead" >{{cat}} </h3>
            <div class="card-container">
                <div v-for="pelicula in peliculasPorCategoria(cat)" :key="pelicula.id">
                    <tarjeta :peli="pelicula" :on-toggle="leerPeliculas"> </tarjeta>
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
        this.loggedUser = this.$route.params.loggedUser;
        API.get("/categories")
            .then(c => this.categorias = c)
            .catch(e => alert(e));
    },

    methods: {
        leerPeliculas() {
            API.get("")
                .then(p => this.peliculas = p)
                .catch(e => alert(e));
        },

        peliculasPorCategoria(categoria) {
            return this.peliculaFilterName
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
</style>