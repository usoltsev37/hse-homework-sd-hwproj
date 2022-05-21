<template>
  <div class="kek">{{msg}}</div>
  <h2>{{msg}}</h2>
</template>

<script>
export default {
  name: "TestComponent",
  props: {
    msg: String
  }
}
</script>

<style scoped>

</style>