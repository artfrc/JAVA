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

        <div class="card">
        <DataTable v-model:filters="filters" :value="customers" paginator showGridlines :rows="10" dataKey="id"
                filterDisplay="menu" :loading="loading" :globalFilterFields="['name', 'country.name', 'representative.name', 'balance', 'status']">
            <template #header>
                <div class="flex justify-between">
                    <Button type="button" icon="pi pi-filter-slash" label="Clear" variant="outlined" @click="clearFilter()" />
                    <IconField>
                        <InputIcon>
                            <i class="pi pi-search" />
                        </InputIcon>
                        <InputText v-model="filters['global'].value" placeholder="Keyword Search" />
                    </IconField>
                </div>
            </template>
            <template #empty> No customers found. </template>
            <template #loading> Loading customers data. Please wait. </template>
            <Column field="nome" header="Nome" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.nome }}
                </template>
                <template #filter="{ filterModel }">
                    <InputText v-model="filterModel.value" type="text" placeholder="Search by name" />
                </template>
            </Column>
            <!-- Country -->
            <Column field="endpoint" header="Endpoint" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.nome }}
                </template>
                <template #filter="{ filterModel }">
                    <InputText v-model="filterModel.value" type="text" placeholder="Search by name" />
                </template>
            </Column>
            <!-- Agent -->
            <Column field="tipo" header="Tipo" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.nome }}
                </template>
                <template #filter="{ filterModel }">
                    <InputText v-model="filterModel.value" type="text" placeholder="Search by name" />
                </template>
            </Column>
            <!-- <Column header="Date" filterField="date" dataType="date" style="min-width: 10rem">
                <template #body="{ data }">
                    {{ formatDate(data.date) }}
                </template>
                <template #filter="{ filterModel }">
                    <DatePicker v-model="filterModel.value" dateFormat="mm/dd/yy" placeholder="mm/dd/yyyy" />
                </template>
            </Column> -->
            <!-- <Column header="Balance" filterField="balance" dataType="numeric" style="min-width: 10rem">
                <template #body="{ data }">
                    {{ formatCurrency(data.balance) }}
                </template>
                <template #filter="{ filterModel }">
                    <InputNumber v-model="filterModel.value" mode="currency" currency="USD" locale="en-US" />
                </template>
            </Column> -->
            <Column field="client_key" header="Chave cliente" style="min-width: 12rem">
                <template #body="{ data }">
                    {{ data.nome }}
                </template>
                <template #filter="{ filterModel }">
                    <InputText v-model="filterModel.value" type="text" placeholder="Search by name" />
                </template>
            </Column>
            <!-- <Column field="activity" header="Activity" :showFilterMatchModes="false" style="min-width: 12rem">
                <template #body="{ data }">
                    <ProgressBar :value="data.activity" :showValue="false" style="height: 6px"></ProgressBar>
                </template>
                <template #filter="{ filterModel }">
                    <Slider v-model="filterModel.value" range class="m-4"></Slider>
                    <div class="flex items-center justify-between px-2">
                        <span>{{ filterModel.value ? filterModel.value[0] : 0 }}</span>
                        <span>{{ filterModel.value ? filterModel.value[1] : 100 }}</span>
                    </div>
                </template>
            </Column> -->
            <Column field="status" header="Status" dataType="boolean" bodyClass="text-center" style="min-width: 8rem">
                <template #body="{ data }">
                    <i class="pi" :class="{ 'pi-check-circle text-green-500 ': data.verified, 'pi-times-circle text-red-500': !data.verified }"></i>
                </template>
                <template #filter="{ filterModel }">
                    <label for="verified-filter" class="font-bold"> Verified </label>
                    <Checkbox v-model="filterModel.value" :indeterminate="filterModel.value === null" binary inputId="verified-filter" />
                </template>
            </Column>
        </DataTable>
    </div>

        <Toast group="br" position="top-right" />
    </div>
</template>


<script setup>

import { FilterMatchMode } from '@primevue/core/api';
import { data } from 'autoprefixer';

export default {
    data() {
        return {
            dt: null,
            
        }
    }
}


</script>