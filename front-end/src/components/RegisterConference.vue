<template>

    <div>
        <Home/>
        <h1><b>Register new conference</b></h1>


        <div class="registerConference">
            <form>
                <div class="form-group" id="conferenceName">
                    <label for="name">Conference name</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter your conference name">
                </div>
                <select class="custom-select" id="location">
                    <option selected>Choose Conference room</option>
                    <option value="1">M/S	Baltic	Queen</option>
                    <option value="2">M/S	 Silja Line</option>
                    <option value="3">M/S	 Romantika room</option>
                    <option value="4">M/S	 Megastar</option>
                </select>
                <div class="form-group" id="ownerName">
                    <label for="owner">Your name</label>
                    <input type="text" class="form-control" id="owner" placeholder="Enter your name">
                </div>
                <div class="form-group" id="date&time">
                    <label for="date">Date</label>
                    <input type="date" class="form-control" id="date">
                    <label for="time">Time</label>
                    <input type="time" class="form-control" id="time">
                </div>

                <button type="submit" class="btn btn-primary">Register</button>
            </form>
        </div>


    </div>

</template>
<script>
    import Home from "../views/Home";
    export default {
        name: 'RegisterConference',
        components: {Home}
    }
</script>

<style >
    h1, h3 {
        padding-left: 5%;
    }
    div.registerConference {
        padding-left: 5%;
        width: 50%;
    }
    label {
        font-weight:bold;
    }
    input {
        width: 50%;
    }
</style>
