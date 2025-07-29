# 📡 Query DLR API

Este documento fornece exemplos de requisições à API utilizando `curl` 🚀

A API oferece um único endpoint `GET /dlr`, que permite o envio de parâmetros opcionais via URL, possibilitando a filtragem de registros DLR conforme os critérios fornecidos.

---

## 🌐 Endpoint

```
GET /dlr
```

---

### 📝 Parâmetros aceitos (todos opcionais)

| Parâmetro         | Formato    | Descrição                                                        |
|-------------------|------------|------------------------------------------------------------------|
| `sourceAddr`      | string     | Identificador do remetente                                       |
| `destinationAddr` | string     | Identificador do destinatário                                    |
| `submissionDate`  | dd-MM-yyyy | Data em que a mensagem foi submetida                             |
| `endDate`         | dd-MM-yyyy | Data da última atualização dos dados da mensagem                 |

---

## 🛠️ Exemplos de Requisições e Respostas

### ✅ Apenas `sourceAddr`
```bash
curl -X GET "http://localhost:8080/dlr?sourceAddr=210"
```

```json
[
  {
    "id": "943f03f-04de-43be-be61-9323fc08f35f",
    "sourceAddr": "210",
    "destinationAddr": "150",
    "submissionDate": "2025-07-18T18:32:10.751+00:00",
    "finalDate": null
  }
]
```

---

### ✅ `sourceAddr` e `destinationAddr`
```bash
curl -X GET "http://localhost:8080/dlr?sourceAddr=210&destinationAddr=150"
```

```json
[
  {
    "id": "943f03f-04de-43be-be61-9323fc08f35f",
    "sourceAddr": "210",
    "destinationAddr": "150",
    "submissionDate": "2025-07-18T18:32:10.751+00:00",
    "finalDate": null
  }
]
```

---

### ✅ Com `submissionDate`
```bash
curl -X GET "http://localhost:8080/dlr?submissionDate=18-07-2025"
```

```json
[
  {
    "id": "e80657bd-7e5d-4f4a-a8ad-de65e5383688",
    "sourceAddr": "270",
    "destinationAddr": "150",
    "submissionDate": "2025-06-16T19:12:24.169+00:00",
    "finalDate": "2025-06-16T19:12:24.169+00:00"
  }
]
```

---

### ✅ Com `endDate`
```bash
curl -X GET "http://localhost:8080/dlr?endDate=18-07-2025"
```

```json
[
  {
    "id": "e80657bd-7e5d-4f4a-a8ad-de65e5383688",
    "sourceAddr": "270",
    "destinationAddr": "150",
    "submissionDate": "2025-06-16T19:12:24.169+00:00",
    "finalDate": "2025-06-16T19:12:24.169+00:00"
  },
  {
    "id": "7743f03f-04de-43be-be61-9323fc08f35f",
    "sourceAddr": "120",
    "destinationAddr": "150",
    "submissionDate": "2025-07-17T13:57:21.173+00:00",
    "finalDate": null
  }
]
```

---

## ❌ Requisição com data inválida

```bash
curl -X GET "http://localhost:8080/dlr?submissionDate=33-12-2026"
```

```json
{
  "type": "about:blank",
  "title": "Bad Request",
  "status": 400,
  "detail": "Failed to convert 'submissionDate' with value: '33-12-2026'",
  "instance": "/dlr"
}
```

⚠️ **Atenção**: o campo `submissionDate` deve estar no formato **dd-MM-yyyy**, com datas válidas (por exemplo, `31-12-2025`).

---