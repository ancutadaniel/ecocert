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
                    url: 'http://localhost:8080/images',
					headers: { 'Authorization': 'Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIxIiwiaWF0IjoxNTY1NDI2MDUzLCJleHAiOjE1NjU1MTI0NTN9._30KWsNBrF7mI0TCvKg60l1HI79kyFMa5NWUMOdT3fCG_QWWUcp6il6jeCntTSAaM3QtgVFT1wGpztHV5S_ccw' },
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
            nextDisabled: true // FIXME change to true, when upload is working
        };

        // This binding is necessary to make `this` work in the callback
        this.handleClick = this.handleClick.bind(this);
    }

    handleClick(e){
        console.log(this.pond.getFiles());

        window.location = '/form';
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
                <Button variant="success" disabled={this.state.nextDisabled} onClick={e => this.handleClick(e)}>Next</Button>
            </Container>
        )}
}

export default AddImage;