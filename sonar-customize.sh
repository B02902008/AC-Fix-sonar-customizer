sonarHome='/opt/sonarqube'
sed -i -e 's/SecurityServletFilter/CustomSecurityServletFilter/g' $sonarHome/web/WEB-INF/web.xml
sed -i -e 's/<style>/<style>#nonav>p>a{display:none}#footer,#global-navigation{display:none}body::-webkit-scrollbar{display:none}body{-ms-overflow-style:none;scrollbar-width:none}/g' $sonarHome/web/index.html