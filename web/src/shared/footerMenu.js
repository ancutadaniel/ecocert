import React from 'react';
import { Navbar, Nav } from 'react-bootstrap';
import { HashLink as Link } from 'react-router-hash-link';

class FooterMenu extends React.Component {
    constructor(props) {
        super(props);
        this.state = {
            modalShow: false
        };
    }
    render() {

        return (
            <Navbar variant="light" expand="sm">
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav ">
                    <Nav className="ml-auto footer_menu">
                        <Link to="/#welcome">Home</Link>
                        <Link smooth  to="/#about">About Us</Link>
                        <Link to="/contact">Contact</Link>
                        <Link to="/">F.A.Q</Link>
                        <Link to="/order">Order</Link>
                        <Link to="/signup">Sign Up</Link>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
        );
    }
}


export default FooterMenu;
