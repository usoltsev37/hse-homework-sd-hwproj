<template>
  <button @click='getHomeworks()' type="button">Get all Homeworks</button>
  <Homeworks :homeworks="homeworks"/>
</template>

<script>
import { getHomeworks } from "@/services/HwService";
import Homeworks from "@/components/Homeworks";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "Student",
  components: {Homeworks},

  methods: {
    getHomeworks() {
      getHomeworks().then(response => {
        this.homeworks = response
      })
    }

  }
}

</script>

<style scoped>

</style>