<template>
  <h2>Homeworks</h2>
  <div class="container mrgnbtm">
    <button @click='getHomeworks()' type="button" class="btn btn-warning">Get Homeworks</button>
  </div>
  <div class="row mrgnbtm">
    <HwTable v-if="homeworks.length > 0" :homeworks="homeworks" />
  </div>
</template>

<script>
import { getHomeworks } from "@/services/HwService";
import HwTable from "@/components/HwTable";

export default {
  name: "StudentPage",
  components: {
    HwTable,
  },

  data() {
    return {
      homeworks: []
    }
  },

  methods: {
    getHomeworks() {
      getHomeworks().then(response => {
        this.homeworks = response
      })
    }

  },

  mounted () {
    this.getHomeworks();
  }
}

</script>

<style scoped>

</style>