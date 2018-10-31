<template>

    <!-- <button disabled="disabled">Ingresar</button> -->
    <div class="container-fluid">
    <nav id="barra-principal" class="navbar navbar-dark bg-dark sticky-top">
        <p id="unqHead-Title">UNQUIFLIX </p>
        <router-link class="btn btn-primary" to="/component1">Ingresar</router-link>
    </nav>


    </div>
    <!-- <ul>
        <li v-for="item in items" :key="item" >
            {{ item.message }}
        </li>
    </ul>    -->

    <!-- <router-view/>  -->

</template>

<script>

export default {
    name: 'ingreso',
    data() {
        return {
            items: [
            { message: 'Foo' },
            { message: 'Bar' }
        ]
        }
        
    }
   
  
    
}
</script>

<style>
    #unqHead-Title {
        color:#c0c0c0;
        font-size:20px;
        font-weight:bold;
    }

</style>