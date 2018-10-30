<template>
    <div class="container-fluid">
        <!-- <input type="search" class="form-control" v-model="peliculasearch" placeholder="Buscar.."> -->
        <nav id="barra-principal" class="navbar navbar-dark bg-dark sticky-top">
      
      <ul class="nav">
        <li class="nav-item">
          <router-link to="/">UnquiFlix</router-link>
        </li>
        </ul>
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
      <div class="card-deck" style="margin: 1rem 1rem">TEXTO QUE HACE QUE</div>
      <div class="card" v-for="pelicula in peliculaFilter" :key="pelicula.id" >
          {{ pelicula.categoria }}
          <!--Card image-->
          <img class="img-fluid" src="../assets/thumb.png" alt="Card image cap">

          <!--Card content-->
          <div class="card-body">
              <!--Title-->
              <h4 class="card-title">{{ pelicula.nombre }}</h4>
              <!--Text-->
              <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
              <a href="#" class="btn btn-primary">Button</a>
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
                 categoria: 'terror'
                 
                },
                {
                    id: 2,
                    nombre: 'Esperando la carroza',
                    categoria: 'romantica'
                }
                ]
            }
            
                

            
        }
    }
</script>


<style scoped>
ul li {color: white;}
.card-deck{background-color:red;}
</style>