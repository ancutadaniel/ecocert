import React from 'react';
import axios from 'axios';
import {Button, Form, Container, Row, Col, Image} from 'react-bootstrap';
import {FormularStyle} from "../styles/index";
import {Electronic, Menajer, Moloz, Platic, Sticla, Metal, Mica, Medie, Mare} from "../../src/images"

class Formular extends React.Component {
    constructor(props) {
        super(props);
        this.apiUrl = "http://localhost:3004/forms";
        this.state = {
            newEvent: {
                info: '',
                trashSize: '',
                trashType: '',
            },
        };

        this.inputChanged = this.inputChanged.bind(this);
        this.formSubmit = this.formSubmit.bind(this);
    }

    async inputChanged(e) {
        const value = e.currentTarget.value;
        const newEvent = this.state.newEvent;
        newEvent[e.currentTarget.name] = value;
        this.setState({newEvent});
        console.log({newEvent});
    }

    async formSubmit(e) {
    debugger;
        e.preventDefault();
        const form = e.currentTarget;
        if (form.checkValidity() === false) {
            return;
        }
        const resp = await axios.post(this.apiUrl, this.state.newEvent);
        console.log(resp.data);
    }


    render() {
        return (
            <Container fluid className="contact_container">
                <Row>
                    <Container className="form_container">

                        <Form noValidate onSubmit={e => this.formSubmit(e)}>
                            <Col>
                                <h2 className="thash_title">Alege <br/> Cantitatea de Gunoi</h2>
                                <Container className="waste">
                                    <Row className="waste_quantity">
                                        <Col xs={4}>
                                            <Form.Label>
                                                <input name="trashSize" type="radio" className="form-check-input"
                                                       value="mica" onChange={this.inputChanged}/>
                                                <Image
                                                    src={Mica}
                                                    width="100%"
                                                    height="auto"
                                                    className="d-inline-block align-top logo"
                                                />
                                            </Form.Label>
                                        </Col>
                                        <Col xs={4}>
                                            <Form.Label>
                                                <input name="trashSize" type="radio" className="form-check-input"
                                                       value="medie" onChange={this.inputChanged}/>
                                                <Image
                                                    src={Medie}
                                                    width="100%"
                                                    height="auto"
                                                    className="d-inline-block align-top logo"
                                                />
                                            </Form.Label>
                                        </Col>
                                        <Col xs={4}>
                                            <Form.Label>
                                                <input name="trashSize" type="radio" className="form-check-input"
                                                       value="mare" onChange={this.inputChanged}/>
                                                <Image
                                                    src={Mare}
                                                    width="100%"
                                                    height="auto"
                                                    className="d-inline-block align-top logo"
                                                />
                                            </Form.Label>
                                        </Col>
                                    </Row>
                                </Container>
                                <Container className="legend">
                                    <p className='small'>Mica</p>
                                    <p className='medium'>Medie</p>
                                    <p className='large'>Mare</p>
                                </Container>
                            </Col>
                            <Col>
                                <h2 className="thash_title">Alege <br/> Tipul de Gunoi</h2>
                                <Form.Group>
                                    <Container className="waste">
                                        <Row className="waste_type">
                                            <Col xs={6}>
                                                <Form.Label>
                                                    <input name="trashType" type="radio" className="form-check-input"
                                                           value="menajer" onChange={this.inputChanged}/>
                                                    <Image
                                                        src={Menajer}
                                                        width="100%"
                                                        height="auto"
                                                        className="d-inline-block align-top logo"
                                                    />
                                                </Form.Label>
                                            </Col>
                                            <Col xs={6}>
                                                <Form.Label>
                                                    <input name="trashType" type="radio" className="form-check-input"
                                                           value="moloz" onChange={this.inputChanged}/>
                                                    <Image
                                                        src={Moloz}
                                                        width="100%"
                                                        height="auto"
                                                        className="d-inline-block align-top logo"
                                                    />
                                                </Form.Label>
                                            </Col>
                                        </Row>
                                        <Row className="waste_type">
                                            <Col xs={6}>
                                                <Form.Label>
                                                    <input name="trashType" type="radio" className="form-check-input"
                                                           value="plastic" onChange={this.inputChanged}/>
                                                    <Image
                                                        src={Platic}
                                                        width="100%"
                                                        height="auto"
                                                        className="d-inline-block align-top logo"
                                                    />
                                                </Form.Label>
                                            </Col>
                                            <Col xs={6}>
                                                <Form.Label>
                                                    <input name="trashType" type="radio" className="form-check-input"
                                                           value="electronic" onChange={this.inputChanged}/>
                                                    <Image
                                                        src={Electronic}
                                                        width="100%"
                                                        height="auto"
                                                        className="d-inline-block align-top logo"
                                                    />
                                                </Form.Label>
                                            </Col>
                                        </Row>
                                        <Row className="waste_type">
                                            <Col xs={6}>
                                                <Form.Label>
                                                    <input name="trashType" type="radio" className="form-check-input"
                                                           value="sticla" onChange={this.inputChanged}/>
                                                    <Image
                                                        src={Sticla}
                                                        width="100%"
                                                        height="auto"
                                                        className="d-inline-block align-top logo"
                                                    />
                                                </Form.Label>
                                            </Col>
                                            <Col xs={6}>
                                                <Form.Label>
                                                    <input name="trashType" type="radio" className="form-check-input"
                                                           value="metal" onChange={this.inputChanged}/>
                                                    <Image
                                                        src={Metal}
                                                        width="100%"
                                                        height="auto"
                                                        className="d-inline-block align-top logo"
                                                    />
                                                </Form.Label>
                                            </Col>
                                        </Row>
                                    </Container>
                                </Form.Group>
                            </Col>
                            <Col className="info">
                                <Form.Group>
                                    <Container>
                                        <Form.Control as="textarea" name="info" rows="3"
                                                      value={this.state.newEvent.info} onChange={this.inputChanged}
                                                      placeholder="Mai multe informatii:"/>
                                    </Container>
                                </Form.Group>
                            </Col>
                            <Col>
                                <Button type="submit" variant="outline-secondary">Trimite</Button>
                            </Col>
                        </Form>
                    </Container>
                </Row>
            </Container>
        )
    }
}


export default Formular;
