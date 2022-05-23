<template>
  <h1>Teacher Page</h1>
  <Homeworks/>
  <HwAdd/>
  <MarkHw/>
  <SubmissionsForTeacher/>
</template>

<script>

import Homeworks from "@/components/Homeworks";
import SubmissionsForTeacher from "@/components/SubmissionsForTeacher";
import HwAdd from "@/components/HwAdd";
import MarkHw from "@/components/MarkHw";

export default {
  // eslint-disable-next-line vue/multi-word-component-names
  name: 'Teacher',
  components: {
    Homeworks,
    SubmissionsForTeacher,
    HwAdd,
    MarkHw
  }
}
</script>

<style>
    @import "@/assets/style/style.css";
</style>
