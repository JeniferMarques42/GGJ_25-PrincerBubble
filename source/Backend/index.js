const express = require("express");
const app = express();
const port = process.env.PORT || 3000; // Porta do servidor

const bodyParser = require("body-parser");
const nodemailer = require("nodemailer");

app.get("/", (req, res) => {
  res.send("Agora foi");
});

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

var transporter = nodemailer.createTransport({
  service: "gmail",
  auth: {
    user: "pincerbubble@gmail.com",
    pass: "gxyt yqrp vpia ovhx",
  },
});

app.post("/sendemail", (req, res) => {
  console.log("Request body:", req.body);

  const { email } = req.body;

  if (!email) {
    return res.status(400).send("Dados incompletos");
  }

  var mailOptions = {
    from: "pincerbubble@gmail.com",
    to: email,
    subject: "Desafio do Rebelde Pincel Bubble - Sua Missão Começa Aqui",
    text: `Olá,

    Eu sou Pincel Bubble, e o destino do nosso mundo depende de você. O governo global está prestes a descobrir nossa localização, e precisamos de alguém com habilidades excepcionais para continuar nossa luta pela liberdade.
    
    Como primeiro passo, preciso testar sua mente. Você está pronto? Aqui vão duas charadas importantes que você deve resolver para encontrar a senha de acesso ao nosso sistema secreto:
    
    Charada 1: Quais são os três números, nenhum dos quais é zero, que dão o mesmo resultado, quer sejam somados ou multiplicados?
    
    Pense com atenção... o tempo está correndo!
    
    Charada 2: Tenha atenção nesta sequência de letras: U D T Q C S S. Agora, pare e pense… Será que você consegue descobrir quais são as próximas 3 letras?
    
    Essas respostas serão a chave para sua próxima missão. Quando tiver a senha, basta respondê-la para desbloquear o acesso a um aplicativo secreto
     onde a verdade é mais bonita que borboletas no jardim.
    
    Lembre-se: o futuro da resistência depende de cada movimento. Não podemos falhar.
    
    Nos vemos no lado certo da história.
    – Pincel Bubble`,
  };

  transporter.sendMail(mailOptions, (err, info) => {
    if (err) {
      console.error("Erro ao enviar o e-mail:", err);
      return res.status(500).send("Erro ao enviar e-mail");
    }
    res.send("OK");
    console.log("E-mail enviado:", info.response);
  });
});
// Iniciar o servidor
app.listen(port, () => {
  console.log(`Servidor rodando na porta ${port}`);
});
