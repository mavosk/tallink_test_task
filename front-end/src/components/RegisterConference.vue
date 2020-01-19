<template>

    <div>
        <Home/>
        <h1><b>Register new conference</b></h1>


        <div class="registerConference">
            <div v-if="error" class="alert alert-danger">
                {{error}}
            </div>
            <div v-if="message" class="alert alert-success">
                {{message}}
            </div>
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
                    <label for="date">Date</label><br>
                    <input type="datetime-local" v-model="date" name="date" id="date" required/>
                </div>


                <button type="submit" class="btn btn-primary">Register</button>

            </form>

        </div>


    </div>

</template>
<script>
    import Home from "../views/Home";
    import apiRequests from './../javascript/apiRequests.js';

    export default {
        name: 'RegisterConference',
        components: {
            Home

        },
        data() {
            return {
                name: "",
                location: "",
                max_seats: 0,
                date: '',
                message: null,
                error: null

            };
        },
        methods: {
            sendData() {

                if (!this.name && this.name.length < 5) {
                    this.error = "Please enter full name";
                } else if (!this.location) {
                    this.error = "Please choose conference location";
                } else if (!this.date) {
                    this.error = "Please choose conference date & time";
                } else {
                    apiRequests.postRequestToApi('/addConference', {
                        name: this.name,
                        location: this.location,
                        max_seats: this.max_seats,
                        date: this.date
                    })
                        .then(() => {
                            this.message = "Conference added successfully.";
                        })
                        .catch(() => {
                            this.error = "Something went wrong, please try again.";
                        });
                }
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
