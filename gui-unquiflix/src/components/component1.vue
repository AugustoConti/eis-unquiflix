<template>
    <div class="container-fluid">
        <!-- <input type="search" class="form-control" v-model="peliculasearch" placeholder="Buscar.."> -->

        <nav id="barra-principal" class="navbar navbar-dark bg-dark sticky-top">
            <p id="unqHead-Title">UNQUIFLIX</p>

         <div class="div-select">
          <select class="custom-select" v-model="peliculasearch" name="" id="">
            <option value="" disabled selected hidden>Elegir la categoria...</option>
            <option >Terror</option>
            <option >Romantica</option>
            <option value=""> todas</option>  
          </select>
        </div>
      </nav>
        
        <!-- <div class="card" style="width: 18rem;">
            <img class="card-img-top" src="..." alt="Card image cap">
            <div class="card-body">
                <h5 class="card-title"></h5>
                <p class="card-text">some quick example text to build.</p>
                <a href="#" class="btn btn-primary">Go somewhere</a>

            </div>
        </div> -->

      
      <!-- <img width="100" :src="image" :alt="title" />  -->
      <!-- <h2>{{title}}</h2> -->
      
      <div class="card" v-for="pelicula in peliculaFilter" :key="pelicula.id" >

          <!--Card image-->
          <img class="img-fluid"  src="../assets/thumb.png"  :alt="pelicula.nombre">

          <!--Card content-->
          <div class="card-body">
              <!--Title-->
              <h4 class="card-title">{{ pelicula.nombre }}</h4>
              <!--Text-->
              <p class="card-text">{{ pelicula.sinopsis }}</p>
              <a :href="pelicula.url" class="btn btn-primary">Ir a la pelicula</a>
            </div>
      </div>
      <!-- <ul>
          <li class="card-title" v-for="pelicula in peliculaFilter" :key="pelicula.id">{{ pelicula.nombre }} - {{ pelicula.categoria }}</li>
            
      </ul> -->
    </div>

</template>

<script>
    export default {
        computed: {
            peliculaFilter: function(){
                var peli=this.peliculasearch
                return this.peliculas.filter(function (elemnt){
                return elemnt.categoria.toLowerCase().indexOf(peli.toLowerCase()) !== -1
                })

            }
        },

        name: "component1",
        data() {
            return {
                peliculasearch: "",
                peliculas: [
                    {
                        id: 1,
                        nombre: 'Volver Al futuro',
                        sinopsis: 'la lal lalalaalal',
                        categoria: 'terror',
                        url: 'http://yahoo.com',
                        image: 'thumb.png'
                    },
                    {
                        id: 2,
                        nombre: 'Esperando la carroza',
                        sinopsis: 'pupupupu pupu pu pu pu ',
                        categoria: 'romantica',
                        url: 'http://google.com',
                        image: 'logo.png'
                    },
                    {
                        id: 3,
                        nombre: 'Esperando la carroza 2',
                        sinopsis: 'unq unq unq ',
                        categoria: 'romantica',
                        url: 'http://google.com',
                        image: 'thumb.png'
                    },
                    {
                        id: 4,
                        nombre: 'Esperando la carroza 3',
                        sinopsis: 'pupupupu pupu pu pu pu ',
                        categoria: 'guerra',
                        url: 'http://google.com',
                        image: 'thumb.png'
                    },
                    {
                        id: 5,
                        nombre: 'Esperando la carroza 4',
                        sinopsis: 'pupupupu pupu pu pu pu ',
                        categoria: 'accion',
                        url: 'http://google.com',
                        image: 'thumb.png'
                    },
                    {
                        id: 6,
                        nombre: 'Esperando la carroza 4',
                        sinopsis: 'pupupupu pupu pu pu pu ',
                        categoria: 'accion',
                        url: 'http://google.com',
                        image: 'thumb.png'
                    }
                ]
            }
            
                

            
        }
    }
</script>


<style scoped>
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
</style>