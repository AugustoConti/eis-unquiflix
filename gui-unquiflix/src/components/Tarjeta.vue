<template>
    <div class="card" v-bind:class="[{noActiva:!peli.activa}]">
        <div class="container" >
            <div class="overlay">
                <a :href="peli.link" class="icon">
                    <i class="fa fa-play-circle"></i>
                </a>

                <router-link class="btn btn-info " :to="{ name: 'component2', params: {pelicula: peli, loggedUser: loggedUser}}">
                    <i class="oi oi-info"></i>
                </router-link>
                <router-link v-if="$parent.loggedUser.esAdmin" class="btn btn-success " :to="{ name: 'pelicula', params: {pelicula: peli, loggedUser: loggedUser}}">
                    <i class="oi oi-pencil"></i>
                </router-link>
                <span @click="togglePelicula" class="disabler" v-if="$parent.loggedUser.esAdmin">
                    <i :class="[ peli.activa ? 'fa fa-eye' : 'fa fa-eye-slash']"></i>
                </span>
                <div v-if="!$parent.loggedUser.esAdmin">
                    <transition name="slide-fade">
                        <div class="container" id="c2" v-if="!loading">
                            <i class="fa fa-star estrella es-elegida" v-for="i in parseInt(puntaje)" :key="i" v-on:click="puntuar(i)"></i>
                            <i class="fa fa-star estrella es-vacia" v-for="i in (5-parseInt(puntaje))" :key="10+i" v-on:click="puntuar(i+puntaje)"></i>
                        </div>
                    </transition>
                </div>
            </div>

            <div class="img-container"><img class="img-fluid image" :src="peli.linkPortada" :alt="peli.titulo"></div>
            <div class="card-body">


                <h4>{{ peli.titulo }}</h4>
                <p class="card-text card-descripcion">{{ peli.descripcion.substring(0, 75)}}...</p>
                <p class="card-text card-estrella">
                    <i class="fa fa-star estrella es-elegida" v-for="i in parseInt(puntaje)" :key="20+i" v-on:click="puntuar(i)"></i>
                    <i class="fa fa-star estrella es-vacia" v-for="i in (5-parseInt(puntaje))" :key="30+i" v-on:click="puntuar(i+puntaje)"></i>
                    ({{puntaje.toFixed(1)}})
                </p>
            </div>

        </div>
    </div>
</template>

<script>
    import API from "../service/api";

    export default {
        data() {
            return {
                loading: false
            }
        },
        created() {
          //this.loggedUser = this.$route.params.loggedUser;
          this.loggedUser = this.$session.get("unqf");
        },
        beforeCreate: function () {
          if (!this.$session.exists()) {
            this.$router.push('/')
          }
        },
        props: {
            peli: {

            },
            onToggle: {
                type: Function,
                required: true
            },
            loggedUser: {
                esAdmin: false
            }
        },
        computed:{
            puntaje: function(){

                if(this.peli.puntuacion.length == 0)
                    return 0;
                var total = 0, length = this.peli.puntuacion.length;
                for (var i = 0; i < length; i++) {
                    total += parseFloat(this.peli.puntuacion[i]);
                }
                return (total / length);
            },
        },
        methods: {

            puntuar:function(valor){
                this.loading=true;

                API.put("/puntuar/"+this.peli.id+"/"+parseInt(valor))
                    .then( this.callBack(this.loading))
                    .catch(e => alert(e));
            },

            callBack(loading){
                this.$parent.leerPeliculas();
                var self = this
                setTimeout(function(){ self.loading=false; }, 1000);
                console.log (this.peli.puntuacion)
            },
            puntaje(){
              if(this.peli.puntuacion.length == 0)
                return 0;
              var total = 0, length = this.peli.puntuacion.length;
              for (var i = 0; i < length; i++) {
                  total += parseFloat(this.peli.puntuacion[i]);
              }
              return Math.round(total / length);
            },
            togglePelicula: function(){
                API.get("/activacion/" + this.peli.id)
                    .then(() => this.onToggle())   
                    .catch(e => alert(e));
            }
        }
    }
</script>

<style scoped>
    .card {
        /*padding-top: 1em;*/
        width: 20%;
        float: left;
        margin: 1vh 1vw 0 0;
        min-height:66vh!important;
    }

    h4 {
        font-size: 1.4em;
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
        transition: 0.3s ease;
        background-color: rgba(0, 0, 0, 0.5);
        padding:10px;
        z-index:1;
    }



    /* When you mouse over the container, fade in the overlay icon*/
    .container:hover .overlay {
        opacity: 1;
    }
    /* The icon inside the overlay is positioned in the middle vertically and horizontally */
    .icon {
        color: white;
        font-size: 5em;
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

    /*Item de menu activacion */
    .disabler {
        color: white;
        float:right;
        text-align: center;

        width:4vw!important;
        height:4vw!important;
        font-size:2vw;
        line-height:4vw;
        padding:0.3em;
        margin:0.2vw;


    }

    .fa-toggle-on {
        font-size: 30px !important;
    }

    .fa-toggle-on:hover {
        cursor: pointer !important;
    }

    .noActiva {
        background-color: rgb(112, 0, 0) !important;
    }

    .estrella{
        font-size:1.5em!important;
    }
    .estrella:hover{
        color:yellow;

    }
    .es-vacia{
        color:#e3ecfc;
    }
    .es-elegida{
        color:#5d95f7;
    }

    /* prev siblings should be red */
    .#c2:hover i  {
        color: #5d95f7;
    }

    #c2 i.estrella:hover ~ i.estrella     {
        color: #e3ecfc;
    }


    .slide-fade-enter-active {
        transition: all .1s ease;
    }
    .slide-fade-leave-active {
        transition: all .1s cubic-bezier(1.0, 0.5, 0.8, 1.0);
    }
    .slide-fade-enter, .slide-fade-leave-to
        /* .slide-fade-leave-active for <2.1.8 */ {
        transform: translateX(10px);
        opacity: 0;
    }


    /*autoajustable*/
    .container{
        padding:0 1vw 0 1vw;
    }
    .card{
        width:17vw;
        font-size: 1em;
        padding-top:0.3em;
        min-height:83vh!important;

    }
    .card-body{
        padding:.3em;


    }

    .img-container{

        max-height: 41vh; /*36*/
        overflow-y: hidden;
    }

    h4{
        max-height:13vh;
        min-height:13vh;
        font-size: 3.3vh;

    }

    .card-descripcion{
        padding-top:4vh!important;
        max-height: 11vh!important;
        min-height:11vh!important;
        font-size: 2.5vh!important;
    }
    .card-estrella{
        position:absolute;
        bottom:0;
        min-height:5vh!important;
        font-size: 1.4vw!important;
    }
    .card-text{
        margin-top:10px!important;

    }

    span {
        width:8%;
        font-size:.5em;
    }

    .overlay .btn-info{
        width:4vw!important;
        height:4vw!important;
        font-size:2vw;
        line-height:4vw;
        padding:0.1vw;
        margin:0;

    }
    .overlay .btn-success{
        width:4vw!important;
        height:4vw!important;
        font-size:2vw;
        line-height:4vw;
        padding:0.1vw;
        margin:0.7vw;
    }

</style>