import React from 'react';
import axios from 'axios';
import { Button, Form, Container, Row, Image, Col } from 'react-bootstrap';
import { Map, Marker, GoogleApiWrapper, InfoWindow } from 'google-maps-react';

class Formular extends React.Component {
    constructor(props) {
        super(props);
        this.apiUrl = "http://192.168.34.8:8081/events";
        this.state = {
            newEvent: {
                info: '',
                trashQuantity: '',
                trashType: '',
                marker: {
                    lat: 44.47599697222223,
                    lng: 26.106394972222223
                },
            },
            showingInfoWindow: false,
            activeMarker: {}
        };

        this.inputChanged = this.inputChanged.bind(this);
        this.formSubmit = this.formSubmit.bind(this);
        this.onMarkerClick = this.onMarkerClick.bind(this);
    }

    async inputChanged(e) {
        const value = e.currentTarget.value;
        const newEvent = this.state.newEvent;
        newEvent[e.currentTarget.name] = value;
        this.setState({ newEvent });
    }

    formSubmit(e) {
        debugger;
        e.preventDefault();
        const form = e.currentTarget;
        if (form.checkValidity() === false) {
            return;
        }
        const resp = axios.post(this.apiUrl, this.state.newEvent);
    }

    onMarkerClick = (props, marker, e) => {
        this.setState({
            showingInfoWindow: true,
            activeMarker: marker
        });
    }

    render() {
        return (
                    <Container fluid className="contact_container" >
                        <Row>
                            <Container className="form_container">
                                <Form noValidate onSubmit={e => this.formSubmit(e)} >
                                    <Form.Group>
                                        <Form.Control as="textarea" id="info"  name="info" rows="3" value={this.state.newEvent.info} onChange={this.inputChanged} placeholder="Leave a comment:"/>
                                    </Form.Group>

                                    <Form.Group>
                                        <Form.Label as="legend" column sm={2}>
                                            Cantitate:
                                        </Form.Label>
                                        <Form.Check
                                            type="radio"
                                            label="SMALL"
                                            name="trashQuantity"
                                            value="SMALL"
                                            onChange={this.inputChanged}
                                        />
                                        <Form.Check
                                            type="radio"
                                            label="Medium"
                                            name="trashQuantity"
                                            value="MEDIUM"
                                            onChange={this.inputChanged}
                                        />
                                        <Form.Check
                                            type="radio"
                                            label="Large"
                                            name="trashQuantity"
                                            value="LARGE"
                                            onChange={this.inputChanged}
                                        />
                                    </Form.Group>

                                    <Form.Group>
                                        <Form.Label as="legend" column sm={2}>
                                            Tip gunoi:
                                        </Form.Label>
                                        <Form.Check
                                            type="radio"
                                            label="MENAJER"
                                            name="trashType"
                                            value="MENAJER"
                                            onChange={this.inputChanged}
                                        />
                                        <Form.Check
                                            type="radio"
                                            label="MOLOZ"
                                            name="trashType"
                                            value="MOLOZ"
                                            onChange={this.inputChanged}
                                        />
                                        <Form.Check
                                            type="radio"
                                            label="PLASTIC"
                                            name="trashType"
                                            value="PLASTIC"
                                            onChange={this.inputChanged}
                                        />
                                        <Form.Check
                                            type="radio"
                                            label="ELECTRONIC"
                                            name="trashType"
                                            value="ELECTRONIC"
                                            onChange={this.inputChanged}
                                        />
                                        <Form.Check
                                            type="radio"
                                            label="METAL"
                                            name="trashType"
                                            value="METAL"
                                            onChange={this.inputChanged}
                                        />

                                        <Form.Check
                                            type="radio"
                                            label="STICLA"
                                            name="trashType"
                                            value="STICLA"
                                            onChange={this.inputChanged}
                                        />
                                    </Form.Group>

                                    <Button type="submit" variant="outline-secondary">Send</Button>
                                </Form>
                                <Map className="map_google" google={this.props.google}
                                     initialCenter={{
                                         lat: this.state.newEvent.marker.lat,
                                         lng: this.state.newEvent.marker.lng
                                     }}
                                     zoom={15}>

                                    <Marker position={{
                                        lat: this.state.newEvent.marker.lat,
                                        lng: this.state.newEvent.marker.lng
                                    }} onClick={this.onMarkerClick} />
                                    <InfoWindow
                                        marker = { this.state.activeMarker }
                                        visible = { this.state.showingInfoWindow }
                                    >
                                        <Container>
                                            <div>
                                            Longitude: {this.state.newEvent.marker.lng}
                                            </div>
                                            <div>
                                            Latitude: {this.state.newEvent.marker.lat}
                                            </div>
                                            <img src='http://192.168.34.8:8081/temp/28D4BD1248E57D5C9DC67BEA83D62715.jpg' />
                                        </Container>

                                    </InfoWindow>
                                </Map>
                            </Container>
                        </Row>
                    </Container>
                    )}
}


export default GoogleApiWrapper({
    apiKey: "AIzaSyA8IRQEYZiMYyOsk5SNapLmyprA5g_Ol1Y"
})(Formular)
