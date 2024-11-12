
## 依赖:
* [Ollama](https://ollama.com/download)
* [Postgresql](https://www.postgresql.org/download/)
* [maven](https://maven.apache.org/download.cgi) (optional)


powershell: `ollama run llama3.2`

### 测试:

```
curl --location 'http://localhost:11434/api/chat' \
--header 'Content-Type: text/plain' \
--data '{
  "model": "llama3.2",
  "messages": [
    { "role": "user", "content": "why is the sky blue?" }
  ]
}'
```

