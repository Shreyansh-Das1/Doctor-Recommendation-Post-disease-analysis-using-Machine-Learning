import pandas as pd
from sklearn.svm import SVC
from sklearn.model_selection import train_test_split 
from sklearn.preprocessing import LabelEncoder
from joblib import dump 


dataset = pd.read_csv('improved_disease_dataset.csv')
x = dataset.drop(['disease', 'department'], axis=1)
y_disease = dataset['disease']
y_department = dataset['department']


label_encoder_disease = LabelEncoder()
y_disease_encoded = label_encoder_disease.fit_transform(y_disease)
label_encoder_department = LabelEncoder()
y_department_encoded = label_encoder_department.fit_transform(y_department)


model_disease = SVC().fit(x, y_disease_encoded)
model_department = SVC().fit(x, y_department_encoded)


dump(model_disease, 'svm_disease_model.joblib')
dump(model_department, 'svm_department_model.joblib')
dump(label_encoder_disease, 'label_encoder_disease.joblib')
dump(label_encoder_department, 'label_encoder_department.joblib')
