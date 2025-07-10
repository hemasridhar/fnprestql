### Sample GraphQL Request
**URL**: http://localhost:8080/graphql
**Request Body:**
_query {
   getDocumentById(id: "{A1B2C3D4-5678-90EF-ABCD-1234567890AB}") {
   id
   name
   createdBy
   mimeType 
  }
}_

