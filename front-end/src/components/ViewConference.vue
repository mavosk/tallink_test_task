<template>
    <div class="home">
        <Home/>

        <div id="registerParticipant" class="container">
            <h2>{{conference.name}} detail information</h2>
            <table class="table">
                <thead>
                <tr>
                    <th>Location</th>
                    <th>Date & time</th>
                    <th>Maximum seats number</th>
                    <th>Status</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <th>{{conference.location}}</th>
                    <th>{{conference.date}}</th>
                    <th>{{conference.max_seats}}</th>
                    <th>{{conference.status}}</th>
                </tr>
                </tbody>
            </table>

            <div v-if="message" class="alert alert-success">
                {{message}}
            </div>
            <h2>Register new paticipant</h2>
            <form class="form-inline" @submit="sendData">

                <div class="form-group p-lg-1" id="participantName">
                    <label for="pname">Participant name</label>
                    <input type="text" class="form-control" v-model="pname" name="name" id="pname"
                           placeholder="Enter full name" required>
                </div>
                <div class="form-group" id="birth_date">
                    <label>Participant's birth date</label>
                    <input type="date" v-model="birth_date" name="name" id="b_date" required>
                </div>
                <button class="btn btn-success">Add</button>
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
                    <tbody v-for="participation in participationList">
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

    export default {
        name: 'ViewConference',
        components: {
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
                participationList: []
            }
        },
        methods: {
            loadConferenceData() {
                apiRequests.getByIdRequestToApi('getConferenceById', this.$route.params.id)
                    .then(result => {
                        this.conference = result.data;
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
                        this.message = "Something went wrong, please try again.";
                    })
            },
            getParticipation() {
                apiRequests.getByIdRequestToApi('/participation', this.$route.params.id)
                    .then(result => {
                        this.participationList = result.data;
                    })
                    .catch(() =>
                        this.participationList = [])
            },
            deleteParticipation(id){
                apiRequests.deleteRequestToApi('/deleteParticipation', id)
                    .then(() => {
                        this.message = `${id} is successfully deleted`;
                        this.getParticipation();
                    })
            }

        }
        ,
        mounted() {
            this.loadConferenceData();
            this.getParticipation();

        }

    }
</script>
<style scoped>
    #registerParticipant {
        padding: 2%;
    }
</style>
