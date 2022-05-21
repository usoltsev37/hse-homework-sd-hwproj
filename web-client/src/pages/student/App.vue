<template>
  <h1>Student Page</h1>
  <Homeworks/>
  <Submission @submitSolution="submitHwSolution($event)"/>
</template>

<script>
import Homeworks from "@/components/Homeworks";
import Submission from "@/components/Submission";

import { submitHomeworkSolution } from "@/services/HwService"

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Student',
  components: {
    Homeworks,
    Submission
  },

  methods: {
    submitHwSolution(data) {
      submitHomeworkSolution(data).then(response => {
        console.log(response)
      })
    }
  }
}
</script>

<style>
 @import "@/assets/style/style.css";
</style>
