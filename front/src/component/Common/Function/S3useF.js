import './S3fileUpload.css'
import {useState} from "react";
import AWS from 'aws-sdk';
import { Row, Col, Button, Input, Alert } from 'reactstrap';
import {v4 as uuidv4} from 'uuid';

const ACCESS_KEY = 'U2FsdGVkX19/rPdNSJxV7t5RImb/hC7xyJj59GQE2qZHcYCg+YNLp7DjsZToXjjo';
const SECRET_ACCESS_KEY = 'U2FsdGVkX1/QSZnZpg510C8WXH6RuDBH6Ge2/l6TlGb0SxzURMhfturuFLYSyzc+cM1Yoqcslv5/B2yToO8l2g==';
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

export function S3useF(file){//img받음
    const [selectedFile, setSelectedFile] = useState(null);
    const [showAlert, setShowAlert] = useState(false);
    const [end,setend]=useState(false)
    const [filebuffer,setFilebuffer]=useState("")
    
    
    const uploadFile = (file1) => {
        const profile_params = {
          ACL: 'public-read',
          Body: file1,
          Bucket: bucket,
          Key: "profile/" + uuidv4() + "." + filebuffer
        };
      
      
        myBucket.putObject(profile_params, (err, data) => {
          alert("complete");
          file1.getfilename("https://bloodrecovery.s3.us-east-2.amazonaws.com/"+profile_params.Key)
          console.log(
              "성공",profile_params.Key);
          console.log(err);
          console.log(data);
      })
      
          setend(true)
        
      }

      const handleFileInput = () => {
        
        const fileExt = file.name.split('.').pop();
        setFilebuffer(fileExt);
        if(file.type !== 'image/png' || fileExt !=='png'){
          alert('jpg 파일만 Upload 가능합니다.');
          return;
        }
        

        console.log("wowwer",file)
        setSelectedFile(file);
      }

      handleFileInput();


    return (uploadFile(selectedFile))
}