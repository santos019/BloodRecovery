import './S3fileUpload.css'
import {useState} from "react";
import AWS from 'aws-sdk';
import { Row, Col, Button, Input, Alert } from 'reactstrap';


const ACCESS_KEY = 'U2FsdGVkX1+SG5rYpcIsEyLP8qdt/p0FwRGuLDstjmaTgmhBQPIMQimQIzwHwBaQ';
const SECRET_ACCESS_KEY = 'U2FsdGVkX1/aj9bp0t551Vmx5gWQLRQePQnfeaYuArhywAYghoZHGPFPiS++PnNsnWammNZxCPnineNpadKDrg==';
const REGION = "U2FsdGVkX194q5BrIV60z6bMqOomihEY7xSZGcnZtrg=";
const S3_BUCKET = 'U2FsdGVkX1/le6BQQXav/Is2yrSyZxJ/oNDzfBSEFx0=';

const CryptoJS = require('crypto-js');
const access = CryptoJS.AES.decrypt(ACCESS_KEY, 'longhair').toString(CryptoJS.enc.Utf8);
const secret = CryptoJS.AES.decrypt(SECRET_ACCESS_KEY, 'longhair').toString(CryptoJS.enc.Utf8);
const region = CryptoJS.AES.decrypt(REGION, 'longhair').toString(CryptoJS.enc.Utf8);
const bucket = CryptoJS.AES.decrypt(S3_BUCKET, 'longhair').toString(CryptoJS.enc.Utf8);

AWS.config.update({
  accessKeyId: access,
  secretAccessKey: secret
});

const myBucket = new AWS.S3({
  params: { Bucket: bucket},
  region: region,
});

 function S3Upload(props) {

const [progress , setProgress] = useState(0);
const [selectedFile, setSelectedFile] = useState(null);
const [showAlert, setShowAlert] = useState(false);



const uploadFile = (file) => {
  const params = {
    ACL: 'public-read',
    Body: file,
    Bucket: bucket,
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
      if (err) {console.log(err)
      alert("파일 업로드가 실패되었습니다.")}
      else props.getfilename(file.name)
    })
    
//에러안나면    
  
}



const handleFileInput = (e) => {
    const file = e.target.files[0];
    const fileExt = file.name.split('.').pop();
    if(file.type !== 'image/png' || fileExt !=='png'){
      alert('jpg 파일만 Upload 가능합니다.');
      return;
    }
    
    console.log(props.sendname)
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