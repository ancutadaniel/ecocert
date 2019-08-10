import React from 'react';
import {  Image, Navbar,Nav } from 'react-bootstrap';
import { Logo } from "../../src/images"
import { LinkContainer } from 'react-router-bootstrap';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';

class MainMenu extends React.Component {
    render() {
        return (
            <Navbar collapseOnSelect expand="lg" bg="primary" variant="dark">
                <Navbar.Brand href="/"><Image
                    src={ Logo }
                    width="2em"
                    height="2em"
                    className="d-inline-block align-top logo"
                /> </Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="ml-auto">
                        <LinkContainer to="/">
                            <Nav.Link>Gunoi<span className="nav_item"><FontAwesomeIcon icon={['fas', 'trash-alt']} size={'lg'}/></span></Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/">
                            <Nav.Link>Reciclare<span className="nav_item"><FontAwesomeIcon icon={['fas', 'recycle']} size={'lg'}/></span></Nav.Link>
                        </LinkContainer>
                        <LinkContainer to="/">
                            <Nav.Link>Login<span className="nav_item"><FontAwesomeIcon icon={['fas', 'user']} size={'lg'}/></span></Nav.Link>
                        </LinkContainer>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}
export default MainMenu;
