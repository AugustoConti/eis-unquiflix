<template>
    <div class="container-fluid" id="component1">
        <!-- <input type="search" class="form-control" v-model="peliculasearch" placeholder="Buscar.."> -->

        <nav id="barra-principal" class="navbar navbar-dark bg-dark fixed-top ">
            <input type="search" v-model="peli_find" placeholder="Buscar..">

            <!-- <option v-for="pelicula in peliculaFilterName" :key="pelicula.titulo">
                        {{pelicula.titulo}}
                    </option> -->
                    
            <p id="unqHead-Title">UNQUIFLIX</p>
            <div class="div-search div-select">
                <input type="text" id="busqueda" />
                
            </div>
            <div class="div-select">
                <select class="custom-select" v-model="peliculasearch" name="" id="">
                    <option value="" disabled selected hidden>Elegir la categoria...</option>
                    <option v-for="cate in categorias" :key="cate">
                        {{cate}}
                    </option>
                    <option value="">TODAS</option>
                </select>
            </div>
        </nav>

        <div class="card" v-for="pelicula in peliculaFilterName" :key="pelicula.id" >

          <!--Card image-->
        <div class="container">
            <img class="img-fluid image" :src="pelicula.linkPortada"  :alt="pelicula.titulo">
            <div class="overlay">
                <a :href="pelicula.link" class="icon" title="Play">
                <i class="fa fa-play-circle"></i>
                </a>
            </div>
        </div>

          <!--Card content-->
          <div class="card-body">
              <!--Title-->
              <h4 class="card-title">{{ pelicula.titulo }}</h4>
              <!--Text-->
              <p class="card-text">{{ pelicula.actores }}</p>
            </div>
      </div>
      
    </div>

</template>

<script>
    import API from '../service/api';
    export default {
        computed: {
            peliculaFilter: function(){
                var peli = this.peliculasearch
                return this.peliculas.filter(e => e.categoria.toLowerCase().indexOf(peli.toLowerCase()) !== -1)
            },
        
            peliculaFilterName: function(){
                 var peliname = this.peli_find
                 return this.peliculaFilter.filter(e => e.titulo.toLowerCase().indexOf(peliname.toLowerCase()) !== -1)
             },

        },

        

        name: "component1",
        data() {
            return {
                peliculasearch: "",
                peliculas: [],
                categorias: [],
                peli_find: "",
            }           
        },

        created(){
            API.get('')
            .then(pelis => this.peliculas = pelis)
                .catch(e=> alert(e))
            //.catch(e => console.log(e))
            API.get('/categories')
            .then(c => this.categorias = c)
                .catch(e=> alert(e))
            //.catch(e => console.log(e))
        }
    }

    
</script>


<style scoped>
  #component1 {
      margin-top: 100px;
    }

    ul li {color: white;}
    .card-deck{background-color:red;}
    .card{
        padding-top:1em;
        width:20%;
        float:left;
        margin:1em 1em  0 0;
        min-height:20em;
    }
    h4{
        font-size:1.4em;
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
  transition: .3s ease;
  background-color: rgba(0, 0, 0, 0.5)
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
    .div-search{
        width:500px!important;

    }
</style>