import './S3fileUpload.css'
import {useState} from "react";
import AWS from 'aws-sdk';
import { Row, Col, Button, Input, Alert } from 'reactstrap';

const ACCESS_KEY = 'AKIA2KQBCRAS2C2XEMPR';
const SECRET_ACCESS_KEY = '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';
const REGION = "us-east-2";
const S3_BUCKET = 'bloodrecovery';

AWS.config.update({
  accessKeyId: ACCESS_KEY,
  secretAccessKey: SECRET_ACCESS_KEY
});

const myBucket = new AWS.S3({
  params: { Bucket: S3_BUCKET},
  region: REGION,
});

 function S3Upload() {

const [progress , setProgress] = useState(0);
const [selectedFile, setSelectedFile] = useState(null);
const [showAlert, setShowAlert] = useState(false);


const uploadFile = (file) => {
  const params = {
    ACL: 'public-read',
    Body: file,
    Bucket: S3_BUCKET,
    Key: "upload/" + file.name
  };
  
  myBucket.putObject(params)
    .on('httpUploadProgress', (evt) => {
      setProgress(Math.round((evt.loaded / evt.total) * 100))
      setShowAlert(true);
      setTimeout(() => {
        setShowAlert(false);
        setSelectedFile(null);
      }, 3000)
    })
    .send((err) => {
      if (err) console.log(err)
    })
}



const handleFileInput = (e) => {
    const file = e.target.files[0];
    const fileExt = file.name.split('.').pop();
    if(file.type !== 'image/png' || fileExt !=='png'){
      alert('jpg 파일만 Upload 가능합니다.');
      return;
    }
    setProgress(0);
    setSelectedFile(e.target.files[0]);
  }

 

      return (
    <div className="S3fileUpload-container">
      <div className="S3fileUpload-body">
        <Row>
          <Col>
            { showAlert?
              <Alert color="primary">업로드 진행률 : {progress}%</Alert>
              : 
              <Alert color="primary">파일을 선택해 주세요.</Alert> 
            }
          </Col>
        </Row>
        <Row>
          <Col>
            <Input color="primary" type="file" onChange={handleFileInput}/>
            {selectedFile?(
              <Button color="primary" onClick={() => uploadFile(selectedFile)}> 파일 업로드</Button>
            ) : null }
          </Col>
        </Row>
      </div>
    </div>
  );

            }


export default S3Upload;