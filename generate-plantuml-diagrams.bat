echo off
echo LOG: Generate Plantuml Diagrams
exportFormat=png
:: set monochrome=true
set extra=-SdefaultFontSize=20
:: set extra=-SdefaultFontName="Times New Roman" -SdefaultFontSize=10

for /r docs %%f in (*.puml) do (
  echo Processing file: %%f
	java -jar libs/plantuml-1.2023.1.jar %extra% -t%exportFormat% "%%f"
)

echo Finished