<template>
    <div class="container-fluid">
        <nav id="barra-principal" class="navbar navbar-dark bg-dark sticky-top">
            <p id="unqHead-Title">UNQUIFLIX </p>
        </nav>
        <h1 class="text-white" align=center>Ingresar a Unquiflix</h1>
        <div class="col-15" align=center>
          <div class="col-5">
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Usuario</label>
                <div class="col-5"><input class="form-control"/></div>
            </div>
            <div class="form-group row">
                <label class="col-3 col-form-label text-white">Contraseña</label>
                <div class="col-5"><input v-model="loginName" class="form-control"/></div>
            </div>
          </div>
        </div>
        <div class="btn-group float-center" role="group">
          <router-link class="btn btn-primary" @onclick="leerUsuario()" :to="{name: 'component1', params: {loggedUser: usuario}}">Ingresar</router-link>
        </div>
    </div>
</template>

<script>
import API from "../service/api";

export default {
    name: "login",
    components: {},
    data() {
        return {
            loginName: "",
            usuario: {}
        };
    },

    methods: {
        leerUsuario(){
            API.get("/loginName/" + this.loginName)
                .then(u => this.usuario = u)
                .catch(e => alert(e));
        }
    }


};
</script>

<style scoped>
</style>