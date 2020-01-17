<template>

    <div>
        <Home/>
        <h1><b>Register new conference</b></h1>


        <div class="registerConference">

            <form @submit="sendData">
                <div class="form-group" id="conferenceName">
                    <label for="name">Conference name</label>
                    <input type="text" class="form-control" v-model="name" name="name" id="name"
                           placeholder="Enter your conference name">
                </div>
                <label>Choose conference room</label>
                <select class="custom-select" v-model="location" id="location" name="location">
                    <option value="1">M/S Baltic Queen</option>
                    <option value="2">M/S Silja Line</option>
                    <option value="3">M/S Romantika room</option>
                    <option value="4">M/S Megastar</option>
                </select>
                <div class="form-group" id="seats_num">
                    <label for="max_seats">Maximum particitaon number: </label>
                    <br>
                    <input type="number" id="max_seats" v-model="max_seats" name="max_seats" min="1"
                           placeholder="Enter number of participant">
                </div>
                <div class="form-group" id="datetime">
                    <label>Date</label>
                    <datetime type="datetime" v-model="date" name="date" id="date"></datetime>
                </div>


                <button type="submit" class="btn btn-primary">Register</button>
            </form>

        </div>


    </div>

</template>
<script>
    import axios from 'axios';
    import Home from "../views/Home";
    import {Datetime} from 'vue-datetime';
    import apiRequests from './../javascript/apiRequests.js';

    export default {
        name: 'RegisterConference',
        components: {
            Home,
            datetime: Datetime,
        },
        data() {
            return {
                name: "",
                location: "",
                max_seats: 0,
                date: ''

            };
        },
        methods: {
            sendData() {

                  apiRequests.postRequestToApi('/addConference', {
                    name: this.name,
                    location: this.location,
                    max_seats: this.max_seats,
                    date: this.date
                })
                    .then(() => {
                        console.log("success");
                    })
                    .catch(() => {
                        console.log("error");
                    });
            }
        }


    }
</script>

<style>
    h1, h3 {
        padding-left: 5%;
    }

    div.registerConference {
        padding-left: 5%;
        width: 50%;
    }

    label {
        font-weight: bold;
    }

    input {
        width: 50%;
    }
</style>
