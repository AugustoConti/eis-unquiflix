<template>
    <div class="container-fluid">
        <h1 class="text-white">Top 10</h1>
        <div v-for="(peli, index) in pelis" :key="peli.id">
            <div class="row">
                <div class="col-5 text-white text-right">
                    <img class="img-fluid image" style="width: 80px" :src="peli.linkPortada" :alt="peli.titulo">
                </div>
                <div class="col-6 text-white">
                    <h2>{{index + 1}}. {{peli.titulo}}</h2>
                    <h3><span class="oi oi-star"></span> {{puntaje(peli)}}</h3>
                </div>
            </div>
        </div>
        <div class="btn-group float-right" role="group">
          <router-link class="btn btn-secondary" :to="{name: 'component1', params: {loggedUser: loggedUser}}">Volver</router-link>
        </div>
    </div>
</template>

<script>
import API from "../service/api";

export default {
  created() {
    this.loggedUser = this.$session.get("unqf");
    API.get("/top")
        .then(p => {
            console.log(p); 
            this.pelis = p;
        })
        .catch(e => alert(e));
  },

  data() {
    return {
      loggedUser: {},
      pelis: [],
    };
  },
  beforeCreate: function () {
        if (!this.$session.exists()) {
            this.$router.push('/')
        }
  },
    methods: {
        puntaje: function(peli){
            if(!peli.puntuacion) return 0;
            if(peli.puntuacion.length == 0)
                return 0;
            var total = 0, length = peli.puntuacion.length;
            for (var i = 0; i < length; i++) {
                total += parseFloat(peli.puntuacion[i]);
            }
            return (total / length).toFixed(1);
        },
    },
};
</script>

<style scoped>
</style>