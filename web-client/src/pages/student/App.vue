<template>
  <h1>Student Page</h1>
  <Homeworks/>
</template>

<script>
import Homeworks from "@/components/Homeworks";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Student',
  components: {
    Homeworks
  }
}
</script>

<style>
 @import "@/assets/style/style.css";
</style>
