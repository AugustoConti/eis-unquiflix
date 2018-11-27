<template>

    <!-- <button disabled="disabled">Ingresar</button> -->
    <div class="container-fluid">
        <nav id="barra-principal" class="navbar navbar-dark bg-dark sticky-top">
            <p id="unqHead-Title">UNQUIFLIX </p>
        
            <router-link class="btn btn-primary btn-rounded" to="/login"  >Ingresar</router-link>
        <!-- <button type="button" class="btn btn-default btn-rounded">Default</button> -->
        <!-- <button type="button" class="btn btn-outline-default btn-rounded waves-effect">Default</button> -->
        
        </nav>
    </div>
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

      /* .btn-primary{
      background: rgb(22, 96, 57)!important;
      border-color:rgb(22, 96, 57)!important;
      color: white;
      margin: 0px 10px 0px 10px;
      padding: 0 20px;
      border-radius: 5px;
      height: 50px;
      line-height: 50px;
      text-align: center;
    } */

    #unqHead-Title {
        color:#c0c0c0;
        font-size:20px;
        font-weight:bold;
    }

</style>