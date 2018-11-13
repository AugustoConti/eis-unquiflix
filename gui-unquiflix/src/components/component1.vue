<template>
    <div class="container-fluid" id="component1">
        <nav id="barra-principal" class="navbar navbar-dark bg-dark fixed-top ">
            <p id="unqHead-Title">UNQUIFLIX</p>
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
                <div class="card" v-for="pelicula in peliculasPorEstreno()" :key="pelicula.id">
                    <div class="container">
                        <img class="img-fluid image" :src="pelicula.linkPortada" :alt="pelicula.titulo">
                        <div class="overlay">
                            <a :href="pelicula.link" class="icon" title="Play">
                                <i class="fa fa-play-circle"></i>
                            </a>
                            <span v-on:click="togglePelicula(pelicula)" class="disabler" title="Activar / Desactivar">
                                <i :class="[ pelicula.activa ? 'fa fa-eye' : 'fa fa-eye-slash']"></i>
                            </span>
                        </div>
                    </div>
                    <div class="card-body">
                        <h4>{{ pelicula.titulo }}</h4>
                        <p class="card-text">{{ pelicula.actores }}</p>
                    </div>
                </div>
            </div>
        </div>
        <div v-for="cat in categoriaFiltered" :key="cat" >
            <h3 class="categoriaHead" >{{cat}} </h3>
            <div class="card-container">
                <div class="card" v-for="pelicula in peliculasPorCategoria(cat)" :key="pelicula.id"
                     v-bind:class="[{noActiva:!pelicula.activa}]">
                    <div class="container">
                        <img class="img-fluid image" :src="pelicula.linkPortada" :alt="pelicula.titulo">
                        <div class="overlay">
                            <a :href="pelicula.link" class="icon">
                                <i class="fa fa-play-circle"></i>
                            </a>
                            <span v-on:click="togglePelicula(pelicula)" class="disabler">
                                <i :class="[ pelicula.activa ? 'fa fa-eye' : 'fa fa-eye-slash']"></i>
                            </span>
                        </div>
                    </div>
                    <div class="card-body">
                        <h4>{{ pelicula.titulo }}</h4>
                        <p class="card-text">{{ pelicula.actores }}</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import API from "../service/api";
import {subDays} from "date-fns";
import moment from "moment";

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
          .map(peli = > peli.categoria
      )
      .
          filter(function (elem, pos, arr) {
              return arr.indexOf(elem) == pos;
          });
    }
  },

  name: "component1",
  data() {
    return {
      peliculasearch: "",
      peliculas: [],
      categorias: [],
        peli_find: "",
        estreno: 3
    };
  },

  created() {
      this.leerPeliculas();

    API.get("/categories")
        .then(c = > (this.categorias = c)
  )
      .catch(e => alert(e));
  },

    methods: {
        leerPeliculas() {
            API.get("")
                .then(pelis = > (this.peliculas = pelis)
        )
        .
            catch(e = > alert(e)
        )
            ;
        },

        togglePelicula(pelicula) {
            API.get("/activacion/" + pelicula.id)
                .then(() = > this.leerPeliculas()
        )
        .
            catch(e = > alert(e)
        )
            ;
        },

        peliculasPorCategoria(categoria) {
            return this.peliculaFilterName.filter(
                pelicula = > pelicula.categoria == categoria
        )
            ;
        },

        peliculasPorEstreno() {
            return this.peliculas.filter(pelicula = > {
                console.log(subDays(new Date(), this.estreno));
            console.log(moment(pelicula.estreno, "YYYY-MM-DD"));
            return (
                moment(pelicula.estreno, "YYYY-MM-DD") >=
                subDays(new Date(), this.estreno)
            );
        })
            ;
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
.card-deck {
  background-color: red;
}
.card {
  padding-top: 1em;
  width: 20%;
  float: left;
  margin: 1em 1em 0 0;
  min-height: 20em;
}
h4 {
  font-size: 1.4em;
}

/* The overlay effect (full height and width) - lays on top of the container and over the image */
.overlay {
  position: absolute;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  height: 100%;
  width: 100%;
  opacity: 0;
  transition: 0.3s ease;
  background-color: rgba(0, 0, 0, 0.5);
}

/* When you mouse over the container, fade in the overlay icon*/
.container:hover .overlay {
  opacity: 1;
}

/* The icon inside the overlay is positioned in the middle vertically and horizontally */
.icon {
  color: white;
  font-size: 100px;
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  -ms-transform: translate(-50%, -50%);
  text-align: center;
}

/* When you move the mouse over the icon, change color */
.fa-user:hover {
  color: #eee;
}

/*Item de menu activacion */
.disabler {
    color: white;
    font-size: 40px;
    position: absolute;
    top: 20px;
    right: 0px;
    transform: translate(-50%, -50%);
    -ms-transform: translate(-50%, -50%);
    text-align: center;
}

.fa-toggle-on {
    font-size: 30px !important;
}

.fa-toggle-on:hover {
    cursor: pointer !important;
}

.div-search {
    width: 500px !important;
}

.noActiva {
    background-color: rgb(112, 0, 0) !important;
}

.categoriaHead {
    position: relative;
    float: left;
    clear: both;
    color: #337ab7;
    font-weight: bold;
    height: 10px;
    line-height: 10px;
    padding-top: 50px;
}
.card-container {
    clear: left;
}
</style>