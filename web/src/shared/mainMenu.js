import React from 'react';
import { Container, Row, Col, Image, ListGroup, Navbar,Nav, ButtonToolbar, Button } from 'react-bootstrap';

import { LinkContainer } from 'react-router-bootstrap';
// import ModalLogin from '../views/pages/ModalLogin';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class MainMenu extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            modalShow: false
        };
    }
    render() {
        // let modalClose = () => this.setState({ modalShow: false });
        return (

                <Navbar bg="primary" variant="light" id="navigation" expand="sm">
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        <Navbar.Brand href="#home" className="logo">
                            <Image
                                src="./ecocert-logo.png"
                                width="auto"
                                height="auto"
                                className="d-inline-block align-top"
                            // alt="React Bootstrap logo"
                            />
                        </Navbar.Brand>
                        <Nav className="mr-auto ">
                            <Nav.Link href="#home">Gunoaie</Nav.Link>
                            <Nav.Link href="#features">Reciclare</Nav.Link>
                            <Nav.Link href="#pricing">Rescue</Nav.Link>
                            <Nav.Link href="#pricing">GDPR</Nav.Link>
                            <Nav.Link>
                                <Image />
                            </Nav.Link>
                        </Nav>
                        <ButtonToolbar>
                            <Button className="btn_mob" variant="outline-success" onClick={() => this.setState({ modalShow: true })}> Log In </Button>
                            {/* <ModalLogin show={this.state.modalShow} onHide={modalClose} /> */}
                        </ButtonToolbar>
                    </Navbar.Collapse>
                  
            </Navbar>
        );
    }
}


export default MainMenu;
