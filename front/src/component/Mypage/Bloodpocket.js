import React from "react";

function Bloodpocket_main() {
  <input
    ref={logoImgInput}
    type="file"
    className="imgInput"
    id="cardImg"
    accept="image/*"
    name="file"
    onChange={onImgChange}
  />;

  const onImgChange = async (event: any) => {
    setLogoLoading(true);
    const formData = new FormData();
    formData.append("file", event.target.files[0]);
    const response = await apiClient.post("/card.jpg", formData);
    setLogoLoading(false);
  };

  event.preventDefault();
  cardImgInput.current.click();
}
