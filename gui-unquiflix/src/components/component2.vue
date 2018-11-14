<template>
    <div class="container-fluid" id="component2">
        <nav id="barra-principal" class="navbar navbar-dark bg-dark fixed-top">
            <p id="unqHead-Title">UNQUIFLIX</p>
        </nav>
        <div v-model="pelicula">
			    <h2><b>{{ pelicula.titulo }}</b></h2>
	            <img class="img-fluid" :src="pelicula.linkPortada"  :alt="pelicula.titulo">
				<h4>{{ pelicula.actores }}</h4>
                <h5>{{ pelicula.descripcion }}</h5>
				<router-link class="btn btn-success" to="/component1">Volver</router-link>
		</div>
    </div>
</template>

<script>
import API from "../service/api";

export default {

  name: "component2",
  components: {
  },

  data() {
    return {
      pelicula: {}
    };
  },
        created() {
            this.pelicula = this.$route.params.pelicula;
        },
    };
</script>

<style scoped>
#component2 {
  margin-top: 90px;
}

ul li {
  color: white;
}

h2 {
    color: white;
    font-size: 2.5em;
    font-weight: bold;
}
h4 {
    color: white;
    font-size: 1.5em;
}
h5 {
    color: white;
    font-size: 1.2em;
}
img {
    width: 15%;
}
</style>