import os
import re


#Variavel para armazenar o padrão de data
date_pattern = r"^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\d{4}$"

#Variaveis para armazenar os usuários
login = ["mar"]
nome = ["marcos"]
senha = ["123"]
carroUsuarioModelo = ["toy"]
carroUsuarioPlaca = ["5y5y5y"]

#Variavel para armazenar o index do usuário logado
indexAtivo = 0

#Variaveis para armazenar os serviços agendados
idServico = ["1", "1" , "2" , "3" , "4" , "5"]
tipoServico = ["Troca de Óleo", "Troca de Óleo", "Troca de Pneu", "Troca de Bateria", "Troca de Freio", "Troca de Suspensão"]
dataServico = ["10/10/2024", "11/11/2024", "12/12/2024", "13/13/2024", "14/14/2024", "15/15/2024"]

#Variaveis para armazenar os serviços finalizados
idServicoFinalizado = []
tipoServicoFinalizado = []
dataServicoFinalizado = []

#Variaveis para armazenar os mecânicos
login_mecanico = ["mec"]
nome_mecanico = ["mecanicoTeste"]
senha_mecanico = ["123"]






#função para verificar se o login já existe
def login_existe(login, lista_logins):
    for login_lista in lista_logins:
        if login == login_lista:
            return True
    return False

#Função para criar um usuário
def criarUsuario():
   
    #Parte de criar usuário
    nomeUsu = input("Digite o nome do usuário: ")
    loginUsu = input("Digite o login do usuário: ")
    while login_existe(loginUsu, login):
        print("Login já existente")
        loginUsu = input("Digite o login do usuário: ")
    
           
    #Parte de criar senha   
    senhaUsu = input("Digite a senha do usuário: ")
    while len(senhaUsu) < 7:
        print("Senha inválida. Digite uma senha com 8 dígitos:")
        senhaUsu = input("Digite a senha do usuário (deve ter 8 dígitos): ")
    aux_carro = input("Digite o modelo do carro: ")
    carroUsuarioModelo.append(aux_carro)
    aux_placa = input("Digite a placa do carro: ")
    carroUsuarioPlaca.append(aux_placa)
    login.append(loginUsu)
    nome.append(nomeUsu)
    senha.append(senhaUsu)
    os.system('cls')
    print("Usuário criado com sucesso")
    menuPrincipal()

#Função para criar um mecânico
def criarMecanico():
    #Parte de criar mecânico
    nomeMec = input("Digite o nome do mecânico: ")
    loginMec = input("Digite o login do mecânico: ")
    while login_existe(loginMec, login_mecanico):
        print("Login já existente")
        loginMec = input("Digite o login do mecânico: ")
    #Parte de criar senha
    senhaMec = input("Digite a senha do mecânico: ")
    while len(senhaMec) < 7:
        print("Senha inválida. Digite uma senha com 8 dígitos:")
        senhaMec = input("Digite a senha do mecânico (deve ter 8 dígitos): ")
    login_mecanico.append(loginMec)
    nome_mecanico.append(nomeMec)
    senha_mecanico.append(senhaMec)
    os.system('cls')
    print("Mecânico criado com sucesso")
    menuPrincipal()
    


#Função para fazer login de usuário    
def fazerLoginUsuario():
  #Parte de fazer login
  j = 0
  while True:
      loginUsu = input("Digite o login: ")
      senhaUsu = input("Digite a senha: ")
      for i in range(len(login)):
        if login[i] == loginUsu and senha[i] == senhaUsu:
            os.system('cls')
            print("Login efetuado com sucesso")
            indexAtivo = i
            menuPrincipalUsuario()
            
        else:
            print("Login ou senha inválidos")
            opcao = input("Deseja tentar novamente? s/n")
            if opcao == "n":
                os.system('cls')
                menuPrincipal()
            
#Função para o menu principal do usuário (depois de logado)                
def menuPrincipalUsuario():
    print(f"Bem vindo {nome[indexAtivo]} ao sistema MechAI")
    print("Escolha uma opção")
    print("1 - Agendar serviço")
    print("2 - Consultar serviços")
    print("3 - Sair")
    opcao = input("Digite a opção desejada: ")
    if opcao == "1":
        os.system('cls')
        agendarServico()
    elif opcao == "2":
        os.system('cls')
        consultarServicos()
    elif opcao == "3":
        os.system('cls')
        menuPrincipal()
    else:
        print("Opção inválida")     

#Função para agendar um serviço        
def agendarServico():
    while True:
        
        print("Agendar serviço")
        print("Escolha o tipo de serviço")
        print("1 - Troca de óleo")
        print("2 - Troca de pneu")
        print("3 - Troca de bateria")
        print("4 - Troca de freio")
        print("5 - Troca de suspensão")
        servico = input("Digite o tipo de serviço: ")
        if servico == "1":
            servico = "Troca de óleo"
            idServico.append(1)
        elif servico == "2":
            servico = "Troca de pneu"
            idServico.append(2)
        elif servico == "3":
            servico = "Troca de bateria"
            idServico.append(3)
        elif servico == "4":
            servico = "Troca de freio"
            idServico.append(4)
        elif servico == "5":
            servico = "Troca de suspensão"
            idServico.append(5)
        else:
            print("Serviço inválido")
            servico = input("Digite o tipo de serviço: ")
        tipoServico.append(servico)
        data = input("Digite a data do serviço (dd-mm-aaaa): ")
        while not re.match(date_pattern, data):
            print("Data inválida")
            data = input("Digite a data do serviço: ")
        dataServico.append(data)
        print("Serviço agendado com sucesso")
        menuPrincipalUsuario()
   
#Função para consultar os serviços agendados        
def consultarServicos():
    os.system('cls')
    print("Consultar serviços")
    if len(tipoServico) == 0:
        os.system('cls')
        print("Nenhum serviço agendado")
        menuPrincipalUsuario()
    for i in range(len(tipoServico)):
        print(f"Serviço: {tipoServico[i]} - Data: {dataServico[i]}")
    menuPrincipalUsuario()
        
    
    
                
#Função para fazer login de mecânico            
def fazerLoginMecanico():
    #Parte de fazer login
    j = 0
    while True:
        loginMec = input("Digite o login: ")
        senhaMec = input("Digite a senha: ")
        for i in range(len(login_mecanico)):
            if login_mecanico[i] == loginMec and senha_mecanico[i] == senhaMec:
                os.system('cls')
                print("Login efetuado com sucesso")
                indexAtivo = i
                menuPrincipalMecanico()
            else:
                print("Login ou senha inválidos")
                opcao = input("Deseja tentar novamente? s/n")
                if opcao == "n":
                    os.system('cls')
                    menuPrincipal()
        
#Função para menu principal do mecânico (depois de logado)        
def menuPrincipalMecanico():
    print(f"Bem vindo {nome_mecanico[indexAtivo]} ao sistema MechAI")
    print(f"Voce possui {len(tipoServico)} serviços agendados")
    print("Escolha uma opção")
    print("1 - Consultar/Finalizar serviço")
    print("2 - Verificar servicos finalizados")
    print("3- Sair")
    opcao = input("Digite a opção desejada: ")
    if opcao == "1":
        os.system('cls')
        finalizarServico()
    elif opcao == "2":
        os.system('cls')
        verificarServicosFinalizados()
    elif opcao == "3":
        os.system('cls')
        menuPrincipal()
    else:
        print("Opção inválida")
   
    
#Função para finalizar um serviço
def finalizarServico():
        if len(tipoServico) == 0:
            print("Nenhum serviço agendado")
            menuPrincipalMecanico()
            return

    # Mostra as opções de serviços para o usuário
        for i, (servico_id, tipo, data) in enumerate(zip(idServico, tipoServico, dataServico)):
            print(f"{i+1} - {tipo} - Data: {data}")

        # Pede ao usuário para escolher o serviço a finalizar
        while True:
            try:
                servico_escolhido = int(input("Digite o número do serviço que deseja finalizar: "))
                if 1 <= servico_escolhido <= len(tipoServico):
                    break
                else:
                    print("Número de serviço inválido. Tente novamente.")
            except ValueError:
                print("Entrada inválida. Digite um número inteiro.")

        # Remove o serviço escolhido das listas e finaliza o serviço
        indice_servico = servico_escolhido - 1
        tipoServicoFinalizado = tipoServico[indice_servico]
        dataServicoFinalizado = dataServico[indice_servico]
        idServicoFinalizado = idServico[indice_servico]

        del idServico[indice_servico]
        del tipoServico[indice_servico]
        del dataServico[indice_servico]

        print(f"Serviço '{tipoServicoFinalizado}' finalizado com sucesso!")
 #   print("Finalizar serviço")
 #   if len(tipoServico) == 0:
 #       os.system('cls')
 #       print("Nenhum serviço agendado")
 #       menuPrincipalMecanico()
 #   for i in range(len(tipoServico)):
 #       print(f" Numero: {i} // Código do Problema: {idServico[i]} // Serviço: {tipoServico[i]} // Data: {dataServico[i]}")
 #   servico = input("Digite o numero do serviço que deseja finalizar ou N para sair: ")
 #   if servico == "N" or servico == "n":
 #       menuPrincipalMecanico()
 #   else:
 #       for i in range(len(tipoServico)):
 #           if servico == tipoServico[i]:
 #               tipoServicoFinalizado.append(tipoServico[i])
 #               dataServicoFinalizado.append(dataServico[i])
 #               idServicoFinalizado.append(idServico[i])
 #               tipoServico.pop(i)
 #               dataServico.pop(i)
 #               idServico.pop(i)
 #               print("Serviço finalizado com sucesso")
 #               finalizarServico()
 #           else:
 #               os.system('cls')
 #               print("Serviço inválido")
 #               finalizarServico()

#Função para verificar os serviços finalizados
def verificarServicosFinalizados():
    while True:
        
        print("Serviços finalizados: ")
        for i in range(len(tipoServicoFinalizado)):
                print(f" id: {idServicoFinalizado[i]} - Serviço: {tipoServicoFinalizado[i]} - Data: {dataServicoFinalizado[i]}")
        
        print("Digite 1 para sair.")
        print("1 - Voltar")
        opcao = input("Digite a opção desejada: ")
        if opcao == "1":
            os.system('cls')
            menuPrincipalMecanico()
        else:
            print("Opção inválida")
            verificarServicosFinalizados()
            
    
  #  menuPrincipalMecanico()
    
#Função para o menu de criar login
def menuCriarLogin():
    print("Escolha qual tipo de login deseja criar")
    print("1 - Usuário")
    print("2 - Mecânico")
    print("3 - Voltar")
    while True:
        opcao = input("Digite a opção desejada: ")
        if opcao == "1":
            criarUsuario()
        elif opcao == "2":
            criarMecanico()
        elif opcao == "3":
            menuPrincipal()
        
        else:
            print("Opção inválida")
            
#Função para escolher o tipo de login (usuário ou mecânico)
def menuFazerlogin():
    print("Escolha qual tipo de login deseja fazer")
    print("1 - Usuário")
    print("2 - Mecânico")
    print("3 - Voltar")
    while True:
        opcao = input("Digite a opção desejada: ")
        if opcao == "1":
            fazerLoginUsuario()
        elif opcao == "2":
            fazerLoginMecanico()
        elif opcao == "3":
            menuPrincipal()
        else:
            print("Opção inválida")
    
#Função para o menu principal
def menuPrincipal():
    indexAtivo = 0
    print("Bem vindo ao sistema de oficina mecânica")
    print("Escolha uma opção")
    print("1 - Criar login")
    print("2 - Fazer login")
    print("3 - Sair")
    opcao = input("Digite a opção desejada: ")
    if opcao == "1":
        menuCriarLogin()
    elif opcao == "2":
        menuFazerlogin()
    elif opcao == "3":
        print("Até mais")
    else:
        print("Opção inválida")
        
    
menuPrincipal()