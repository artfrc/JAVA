<template>
    <div class="card flex justify-center">
        <Button 
            label="Adicionar cliente" 
            icon="pi pi-plus" 
            @click="openModal" 
        />
        
        <Dialog 
            v-model:visible="visible" 
            header="Novo Cliente" 
            :style="{ width: '500px' }"
            :modal="true"
            :closable="false"
        >
            <div class="p-fluid">
                <div class="field mb-3">
                    <label for="name" class="block mb-2">Nome</label>
                    <InputText 
                        id="name" 
                        v-model="formData.name" 
                        placeholder="Digite o nome"
                        class="w-full"
                    />
                </div>

                <div class="field mb-3">
                    <label for="endpoint" class="block mb-2">Endpoint</label>
                    <InputText 
                        id="endpoint" 
                        v-model="formData.endpoint" 
                        placeholder="Digite o endpoint"
                        class="w-full"
                    />
                </div>

                <div class="field mb-3">
                    <label for="type" class="block mb-2">Tipo</label>
                    <Dropdown 
                        id="type"
                        v-model="formData.type" 
                        :options="typeOptions" 
                        optionLabel="label"
                        optionValue="value"
                        placeholder="Selecione o tipo"
                        class="w-full"
                    />
                </div>
            </div>
            
            <template #footer>
                <Button 
                    label="Cancelar" 
                    icon="pi pi-times" 
                    @click="closeModal" 
                    class="p-button-text mr-2" 
                />
                <Button 
                    label="Salvar" 
                    icon="pi pi-check" 
                    @click="saveConfiguration" 
                    :disabled="!isFormValid"
                    autofocus 
                />
            </template>
        </Dialog>
    </div>
</template>

<script setup>
import { ref, reactive, computed } from 'vue';
import Button from 'primevue/button';
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Dropdown from 'primevue/dropdown';

const visible = ref(false);
const formData = reactive({
    name: '',
    endpoint: '',
    type: null
});

const typeOptions = [
   { label: '', value: null},
    { label: 'SMSC', value: 'SMSC' },
    { label: 'NO_AUTH', value: 'NO_AUTH' }
];

const isFormValid = computed(() => {
    return formData.name.trim() && formData.endpoint.trim() && formData.type;
});

const openModal = () => {
    visible.value = true;
};

const closeModal = () => {
    visible.value = false;
    resetForm();
};

const resetForm = () => {
    formData.name = '';
    formData.endpoint = '';
    formData.type = null;
};

const saveConfiguration = () => {
    console.log('Configuração salva:', formData);
    // Sua lógica de salvamento aqui
    closeModal();
};
</script>