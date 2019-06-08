import React from 'react';
import axios from 'axios';
import { Button, Form, Container, Row, Image, Col } from 'react-bootstrap';


class Formular extends React.Component {
    constructor(props) {
        super(props);
        this.apiUrl = "http://192.168.34.8:8081/events";
        this.state = {
            newEvent: {
                info: '',
                trashQuantity: '',
                trashType: ''
            }
        };

        this.inputChanged = this.inputChanged.bind(this);
        this.formSubmit = this.formSubmit.bind(this);
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

    render() {
        return (
            <Container fluid className="contact_container" >
                <Row>
                    <Container className="form_container">
                        <Form noValidate onSubmit={e => this.formSubmit(e)} >
                            <Form.Group>
                                <Form.Control as="textarea" id="info"  name="info" rows="3" value={this.state.info} onChange={this.inputChanged} placeholder="Leave a comment:"/>
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
                                    label="METAL"
                                    name="trashType"
                                    value="METAL"
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
                                    label="STICLA"
                                    name="trashType"
                                    value="STICLA"
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
                                    label="MOLOZ"
                                    name="trashType"
                                    value="MOLOZ"
                                    onChange={this.inputChanged}
                                />
                                <Form.Check
                                    type="radio"
                                    label="MENAJER"
                                    name="trashType"
                                    value="MENAJER"
                                    onChange={this.inputChanged}
                                />
                            </Form.Group>

                            <Button type="submit" variant="outline-secondary">Send</Button>
                        </Form>
                    </Container>
                </Row>
            </Container>
        );
    }
}


export default Formular;
