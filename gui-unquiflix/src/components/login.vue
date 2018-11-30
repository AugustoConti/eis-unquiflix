<template>
  <div class="blurred-bg-container">
    <div class="content">
      <form class="form-signin">
        <img class="centered transparente login-logo" src="../assets/logoback.png" alt="Logo" />
        <h1 class="text-danger text-center display-4 font-weight-bold">UNQUIFLIX</h1>
        <div class="login-button">
          <input
                  id="inputUser"
                  class="form-control"
                  placeholder="Usuario"
                  required
                  v-model="loginName"
          />
          <input type="password"
                 id="inputPassword"
                 class="form-control"
                 placeholder="Password"
                 required
                 v-model="password"
          />
          <button class="form-control btn btn-danger" v-on:click="logear"><h3 class="m-0">Entrar</h3></button>
        </div>
      </form>
      <div class="blur" />
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
                password:"",
                usuario: {}
            };
        },
        methods: {
            logear(){
                API.get("/loginName/" + this.loginName + "/"+ this.password)
                    .then(response => this.validarSesion(response))
            .catch(e => alert(e));
            },

            validarSesion(respuesta){
                this.$session.start()
                this.$session.set('unqf', respuesta.body)
                this.$router.push({name: 'component1', params: {loggedUser: respuesta}})
            }
        }
    };
</script>

<style scoped>
  .blurred-bg-container {
    background: url("../assets/background.jpg");
    background-size: cover;
    height: 100vh;
  }

  .form-signin {
    width: 100%;
    max-width: 330px;
    padding: 15px;
    margin: auto;
    align-items: center;
    border-radius:8px;
    backdrop-filter: blur(5px);
    background-color: rgba(0, 0, 0, 0.5);
  }

  .blurred-bg-container .content {
    background: inherit;
    border-radius:8px;
    box-shadow: 0 0 32px rgba(0, 0, 0, 0.95);
    position: absolute;
    top: 40%;
    left: 50%;
    transform: translate(-50%, -50%);
    overflow: hidden;
  }

  .blurred-bg-container .blur {
    background: inherit;
    height: 100vh;
    width: 420%;
    position: absolute;
    left: 0;
    top: 0;
    transform: translate(-38.1%,-9.4%);
    filter: blur(10px);
    z-index: -1;
    border-style: none;
  }

  .form-signin .form-control {
    position: relative;
    box-sizing: border-box;
    height: auto;
    padding: 15px;
    font-size: 16px;
    border-style: none;
  }

  .blurred-bg-container .login-button .form-control {
    margin: 5px;
    padding: 15px;
  }

  .transparente {
    background-color: rgba(0, 0, 0, 0);
    border-style: none;
  }

  .login-logo {
    display: block;
    margin-left: auto;
    margin-right: auto;
    width: 70%;
  }
</style>