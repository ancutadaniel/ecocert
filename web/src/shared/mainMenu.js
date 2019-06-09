import React from 'react';
import { Container, Row, Col, Image, ListGroup, Navbar,Nav, ButtonToolbar, Button, NavDropdown } from 'react-bootstrap';

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

            <Navbar collapseOnSelect expand="lg" bg="primary" variant="dark">
                <Navbar.Brand href="/"><Image 
                    src="./ecocert-logo.png"
                    width="100%"
                    height="auto"
                    className="d-inline-block align-top logo"
                // alt="React Bootstrap logo"
                /> </Navbar.Brand>
                <Navbar.Toggle aria-controls="responsive-navbar-nav" />
                <Navbar.Collapse id="responsive-navbar-nav">
                    <Nav className="mr-auto">
                        <LinkContainer to="/gunoaie">
                            <Nav.Link><span className="trash"><FontAwesomeIcon icon={['fas', 'trash-alt']} size={'lg'}/></span>Gunoaie</Nav.Link>
                        </LinkContainer>
                         <LinkContainer to="/reciclare">
                            <Nav.Link><span className="rec"><FontAwesomeIcon icon={['fas', 'recycle']} size={'lg'}/></span>Reciclare</Nav.Link>
                        </LinkContainer>                       
                        <NavDropdown title="Rescue" id="collasible-nav-dropdown">
                            <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                            <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                            <NavDropdown.Divider />
                            <NavDropdown.Item href="#action/3.4">Action</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>                   
                </Navbar.Collapse>
            </Navbar>


            
          

               
        );
    }
}


export default MainMenu;
