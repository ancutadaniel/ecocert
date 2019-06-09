import React from 'react';

import { FilePond, registerPlugin } from 'react-filepond';
import 'filepond/dist/filepond.min.css'

import FilePondPluginImagePreview from 'filepond-plugin-image-preview';
import 'filepond-plugin-image-preview/dist/filepond-plugin-image-preview.min.css';

import FilePondPluginFileValidateType from 'filepond-plugin-file-validate-type';

import { Container, Button } from 'react-bootstrap';

registerPlugin(FilePondPluginImagePreview, FilePondPluginFileValidateType);

class AddImage extends React.Component {
    constructor(props) {
        super(props);

        this.state = {
            server: {
                process: {
                    url: 'http://192.168.34.8:8081/images',
                    withCredentials: false,
                    onload: (response) => {response = JSON.parse(response); return response.imageUUID },
                },
                fetch: null,
                revert: null,
                restore: null,
                load: null
            },
            acceptedFileTypes: ['image/*'],
            required: true,
            nextDisabled: true
        };

        // This binding is necessary to make `this` work in the callback
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(){
        console.log(this.pond.getFiles());
        window.location = '/formular';
    }

    render() {
        return (
            <Container fluid className="addimage">
                <FilePond ref={ref => this.pond = ref} allowMultiple={true} server={this.state.server} acceptedFileTypes={this.state.acceptedFileTypes}
                          required={this.state.required}
                          onprocessfiles={(fileItems) => {
                              this.setState({
                                  nextDisabled: false
                              });
                          }}
                />
                <Button variant="success" disabled={this.state.nextDisabled} onClick={this.handleClick}>Next</Button>
            </Container>
        );
    }
}

export default AddImage;