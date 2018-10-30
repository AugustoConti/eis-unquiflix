<template>
    <div >
        <nav id="barra-principal" class="navbar navbar-dark bg-dark sticky-top">
      
      <ul class="nav">
        <li class="nav-item">
          <router-link to="/">UnquiFlix</router-link>
        </li>
        </ul>
        <div class="div-select">
          <select class="custom-select" name="" id="">
            <option value="" disabled selected hidden>Elegir la categoria...</option>
            <option value="">Terror</option>
            <option value="">Romantica</option>
          </select>
        </div>
      </nav>
        


      
      <!-- <img width="100" :src="image" :alt="title" /> -->
      <!-- <h2>{{title}}</h2> -->
      <ul>
          <li  v-for="pelicula in peliculas" :key="pelicula.id">{{ pelicula.nombre }} - {{ pelicula.categoria }}</li>
            
      </ul>
    </div>

</template>

<script>
    export default {
        name: "component1",
        data() {
            return {
                peliculas: [
                {
                 id: 1,           
                 nombre: 'pepe1',
                 categoria: 'terror'
                 
                },
                {
                    id: 2,
                    nombre: 'pepe2',
                    categoria: 'romantica'
                }
                ]
            }
            
                

            
        }
    }
</script>


<style scoped>
ul li {color: white;}
</style>