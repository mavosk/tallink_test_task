<template>
    <div class="home">
        <UpperNavBar/>

        <div id="conferenceInformation" class="container">
            <h2>{{conference.name}} detail information</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Location</th>
                    <th>Date & time</th>
                    <th>Maximum participant number</th>
                    <th>Registered participant number</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>{{conference.location}}</th>
                    <th>{{conference.date}}</th>
                    <th>{{conference.max_seats}}</th>
                    <th>{{participant_num}}</th>
                    <th>{{conference.status}}</th>
                </tr>
                </tbody>
            </table>

            <div v-if="message" class="alert alert-success">
                {{message}}
            </div>
            <div v-if="error" class="alert alert-info">
                {{error}}
            </div>
            <h2>Register new paticipant</h2>
            <form class="form-inline" @submit="sendData" id="registerForm"  >

                <div class="form-group p-lg-1" id="participantName">
                    <label for="pname">Participant name</label>
                    <input type="text" class="form-control" v-model="pname" name="name" id="pname"
                           placeholder="Enter full name" required>
                </div>
                <div class="form-group" id="birth_date">
                    <label>Participant's birth date</label>
                    <input type="date" v-model="birth_date" name="name" id="b_date" required>
                </div>
                <button class="btn btn-success" id="addButton" :disabled="participant_num >= max_seats">Add</button>
            </form>


            <div>
                <h2>Participation:</h2>
                <table class="table">
                    <thead>
                    <tr>
                        <th>Person name</th>
                        <th>Conference id</th>
                        <th>Birth date</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody v-for="participation in participation_list">
                    <tr>
                        <td>{{participation.name}}</td>
                        <td>{{participation.conference_id}}</td>
                        <td>{{participation.birth_date}}</td>
                        <td>
                            <button class="btn btn-warning"
                                    v-on:click="deleteParticipation(participation.id)">
                                Delete
                            </button>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    import Home from "../views/Home";
    import apiRequests from './../javascript/apiRequests.js';
    import {Datetime} from 'vue-datetime';
    import UpperNavBar from "../layouts/UpperNavBar";


    export default {
        name: 'ViewConference',
        components: {
            UpperNavBar,
            datetime: Datetime,
            Home
        },
        data() {
            return {
                conference: [],
                birth_date: '',
                pname: '',
                conference_id: '',
                message: null,
                error : null,
                participation_list: [],
                participant_num : 0,
                max_seats : 0,
            }
        },
        methods: {
            loadConferenceData() {
                apiRequests.getByIdRequestToApi('getConferenceById', this.$route.params.id)
                    .then(result => {
                        this.conference = result.data;
                        this.max_seats = result.data.max_seats;

                    });

            },
            sendData() {
                apiRequests.postRequestToApi('/addParticipation', {
                        name: this.pname,
                        conference_id: this.$route.params.id,
                        birth_date: this.birth_date
                    }
                )
                    .then(() => {
                        this.message = "Successfully added to conference";
                    })
                    .catch(() => {
                        this.error = "Something went wrong, please try again.";
                    })
            },
            getParticipation() {
                apiRequests.getByIdRequestToApi('/participation', this.$route.params.id)
                    .then(result => {
                        this.participation_list = result.data;
                    })
                    .catch(() =>
                        this.participation_list = []);
            },
            countParticipation() {
                apiRequests.getByIdRequestToApi('/countParticipation', this.$route.params.id)
                    .then(result => {
                        this.participant_num = result.data;
                    });
            },
            deleteParticipation(id){
                apiRequests.deleteRequestToApi('/deleteParticipation', id)
                    .then(() => {
                        this.message = `Participant is successfully deleted`;
                        this.getParticipation();
                        this.countParticipation();
                    })
            }

        }
        ,
        mounted() {
            this.loadConferenceData();
            this.getParticipation();
            this.countParticipation();


        }

    }
</script>
<style scoped>
    #conferenceInformation {
        padding: 2%;
    }

</style>
