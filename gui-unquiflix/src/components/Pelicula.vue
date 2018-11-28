<template>
    <div class="container-fluid">
        <h1 class="text-white">{{this.isNew ? 'Nueva' : 'Editar'}} Película</h1>
        <div class="row">
          <div class="col-4">
            <img class="w-75 p-3" :src="source" :alt="peli.titulo" />
          </div>
          <div class="col-6">
            <div class="form-group row">
              <div class="col-9">
                <input type="checkbox" id="checkbox" v-model="peli.activa">
                <label class="text-white" for="checkbox">Activa</label>
              </div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Titulo</label>
                <div class="col-9"><input v-model="peli.titulo" class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Descripción</label>
                <div class="col-9"><input v-model="peli.descripcion" class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Categoría</label>
                <div class="col-9"><input v-model="peli.categoria" class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Fecha de estreno</label>
                <div class="col-9"><input v-model="peli.estreno" class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Directores</label>
                <div class="col-9"><input v-model="peli.directores" class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Actores</label>
                <div class="col-9"><input v-model="peli.actores" class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Link</label>
                <div class="col-9"><input v-model="peli.link" class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Portada</label>
                <div class="col-9"><input v-model="peli.linkPortada" class="form-control"/></div>
            </div>
          </div>
        </div>
        <div class="btn-group float-right" role="group">
          <router-link class="btn btn-secondary" :to="{name: 'component1', params: {loggedUser: loggedUser}}">Cancelar</router-link>
          <button class="btn btn-primary" v-on:click="send">Aceptar</button>
        </div>
    </div>
</template>

<script>
import API from "../service/api";

export default {
  created() {
    this.isNew = this.$route.params.pelicula == null 
    this.peli = this.$route.params.pelicula || {
            titulo: "", //String
            categoria: "", //Categoria
            estreno: "", //LocalDate
            descripcion: "",//String
            directores: "",//String
            actores: "",//String
            link: "",//String
            linkPortada: "",//String
            activa: true,//Boolean
            puntuacion: [],
        };
  },

  data() {
    return {
      loggedUser: {},
      peli: this.pelicula,
      defaultImage: 'https://upload.wikimedia.org/wikipedia/commons/a/ac/No_image_available.svg',
      isNew: true,
    };
  },

  computed: {
    source() {
      return this.peli.linkPortada || this.defaultImage;
    }
  },

  methods: {
    send: function () {
      API.post('/pelicula', { ...this.peli })
      .then(() => this.$router.push({name: 'component1', params: {loggedUser: this.loggedUser}}))
      .catch(alert);
    }
  }
};
</script>

<style scoped>
</style>