import React from 'react';
import '../../App.css';
import '../../Contact.css';
import UserContext from '../../shared/user.context';
import { Redirect } from 'react-router-dom';
import axios from 'axios';
import { Button, Form, Container, Row, Image, Col } from 'react-bootstrap';
import { logo } from '../../images/index';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class Formular extends React.Component {
    constructor(props) {
        super(props);
        this.apiUrl = "http://localhost:3004/contact";
        this.state = {
            id: 0,
            user: {},
            name: '',
            email: '',
            commentId: 0,
            comment:'',
            validated: false,
            isValid: true
        };

        this.inputChanged = this.inputChanged.bind(this);
        this.formSubmit = this.formSubmit.bind(this);
    }

    async inputChanged(e) { // boiled plate
        const value = e.currentTarget.value;
        const user = this.state.user;
        user[e.currentTarget.id] = value;
        this.setState({ user });

    }

    async formSubmit(e) {
        e.preventDefault();
        const form = e.currentTarget;
        if (form.checkValidity() === false) {
            return;
        }

        const resp = await axios.post(this.apiUrl, this.state.user);
        console.log(resp.data);
        console.log(this.state.user.comment);

        this.context.handleUserChange(resp.data);
        this.setState({ validated: true, user: resp.data, redirect: true });
    }

    render() {
        if (this.state.redirect === true) {
            return (
                <Redirect to='/' />
            );
        }
        const { validated } = this.state;
        return (
            <UserContext.Consumer>
                {({ user, handleUserChange }) => (
                    <Container fluid className="contact_container" >
                        <Row>
                            <Container className="form_container">
                                <Image src={logo} width="80" height="80" className="d-inline-block align-top" alt="React Bootstrap logo" />
                                <Col>
                                    <h2><FontAwesomeIcon icon={['fas', 'edit']} size={'lg'} />Contact Us</h2>
                                </Col>
                                <Form noValidate validated={validated} onSubmit={e => this.formSubmit(e)} >
                                        <Form.Group className="form_name">
                                            <Form.Control required id="name" type="text" value={this.state.user.name} onChange={this.inputChanged} placeholder="Name" />
                                            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                                            <Form.Control.Feedback type="invalid">Please enter a name.</Form.Control.Feedback>
                                        </Form.Group>
                                        <Form.Group className="form_email">
                                            <Form.Control required id="email" type="email" value={this.state.user.email} onChange={this.inputChanged} placeholder="Enter email" />
                                            <Form.Control.Feedback>Looks good!</Form.Control.Feedback>
                                            <Form.Control.Feedback type="invalid">Please provide a valid email.</Form.Control.Feedback>
                                        </Form.Group>
                                    <Form.Group>
                                        <Form.Control as="textarea" id="comment" rows="3" value={this.state.user.comment} onChange={this.inputChanged} placeholder="Leave a comment:"/>

                                    </Form.Group>
                                    <Button type="submit" variant="outline-secondary"><a className="send" href="mailto:{this.state.user.email}">Send</a></Button>
                                </Form>
                                <p>{!this.state.isValid ? ("Name, email or password is missing") : ''}</p>
                            </Container>
                        </Row>
                    </Container>
                )}
            </UserContext.Consumer>
        );
    }
}

Formular.contextType = UserContext;

export default Formular;
