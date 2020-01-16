<template>
  <div class="home">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <a class="navbar-brand" href="/">Home</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        <div class="navbar-nav">
          <a class="nav-item nav-link" href="/registerConference">Register conference</a>
          <a class="nav-item nav-link" href="/cancelConference">Cancel conference</a>
          <a class="nav-item nav-link" href="#">Edit conference</a>
        </div>
      </div>
    </nav>
    <MainPage/>
  </div>

</template>

<script>
import MainPage from '@/components/MainPage.vue'

export default {
  name: 'Home',
  components: {
    MainPage
  }
}
</script>
