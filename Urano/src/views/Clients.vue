<template>

    <div class="card">

        <div class="flex justify-end">
            <Button 
                label="Adicionar cliente" 
                icon="pi pi-plus" 
                @click="openModal" 
            />
        </div>
        
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
                
                <Button label="Salvar" 
                icon="pi pi-check" 
                @click="saveClient" 
                :disabled="!isFormValid"
                    autofocus 
                />
                
            </template>
        </Dialog>

        <Toast group="br" position="top-right" />
    </div>
</template>


<script setup>
import { ref, reactive, computed } from 'vue';
import Button from 'primevue/button';
import Dialog from 'primevue/dialog';
import InputText from 'primevue/inputtext';
import Dropdown from 'primevue/dropdown';
import { useToast } from "primevue/usetoast";

const toast = useToast();
const visible = ref(false);
const formData = reactive({
    name: '',
    endpoint: '',
    type: null
});

const typeOptions = [
   { label: '', value: null},
    { label: 'SMSC', value: 'SMSC' },
    { label: 'SENSEDIA', value: 'SENSEDIA' },
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

const saveClient = () => {
    toast.add({ severity: 'success', detail: 'Cliente inserido com sucesso!', group: 'br', life: 1000 });
    console.log('Configuração salva:', formData);
    closeModal();
};

</script>