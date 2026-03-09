from fastapi import FastAPI
from pydantic import BaseModel
import xml.etree.ElementTree as ET

app = FastAPI()

class XmlRequest(BaseModel):
    xml_content: str

@app.post("/extract")
def extract_fields(request: XmlRequest):

    root = ET.fromstring(request.xml_content)

    data = {}
    for child in root:
        data[child.tag] = child.text

    return data