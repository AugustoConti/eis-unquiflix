<template>
    <div class="container-fluid" id="component2">
        <div>
            <div class="row">
                <div class="col-4">
                    <img class="w-100 p-3" :src="pelicula.linkPortada"  :alt="pelicula.titulo">
                </div>
                <div class="col-8">
                    <h2><b>{{ pelicula.titulo }}</b></h2>
                    <h4>Descripción: {{ pelicula.descripcion }}</h4>
                    <h5>Categoría: {{ pelicula.categoria }}</h5>
                    <h5>Directores: {{ pelicula.directores }}</h5>
                    <h5>Actores: {{ pelicula.actores }}</h5>
                    <h5>Fecha de estreno: {{ pelicula.estreno }}</h5>
                    <router-link class="btn btn-success" :to="{ name: 'component1', params: {loggedUser: loggedUser}}">Volver</router-link>
                </div>
            </div>
		</div>
    </div>
</template>

<script>

export default {
    name: "component2",
    components: {},

    data() {
        return {
            pelicula: {},
            loggedUser: {}
        };
    },
    created() {
        this.pelicula = this.$route.params.pelicula;
        this.loggedUser = this.$session.get("unqf");
    },
    beforeCreate: function () {
        if (!this.$session.exists()) {
            this.$router.push('/')
        }

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