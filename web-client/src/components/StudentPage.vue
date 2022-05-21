<template>
  <div class="container mrgnbtm">
    <div class="row">
      <div class="col-md-4">
        <HwBoard :number-of-hws="numberOfHws" @getHomeworks="getHomeworks()" />
      </div>
    </div>
  </div>
  <div class="row mrgnbtm">
    <Homeworks v-if="homeworks.length > 0" :homeworks="homeworks" />
  </div>
  <p></p>
</template>

<script>
import { getHomeworks } from "@/services/HwService";
import Homeworks from "@/components/Homeworks";
import HwBoard from "@/components/HwBoard";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: "StudentPage",
  components: {
    Homeworks,
    HwBoard
  },

  data() {
    return {
      homeworks: [],
      numberOfHws: 0
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